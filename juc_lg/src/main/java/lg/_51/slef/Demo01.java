package lg._51.slef;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author lnd
 * @Description
 *      Q：使用 CompletableFuture 开启3个任务，使用 resultList 收集结果，模拟出现1个超时，2个未超时。看看最终2个未超时的结果能否收集到
 *      A：超时的任务会抛出异常，但不会影响其他未超时任务结果的收集
 * @Date 2024/4/18 20:39
 */
@Slf4j
public class Demo01 {
    public static void main(String[] args) {
        List<String> resultList = new ArrayList<>();
        List<CompletableFuture> futureList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            long num = i;
            CompletableFuture<Void> task = CompletableFuture.runAsync(() -> {
                // 模拟耗时操作
                try {
                    TimeUnit.SECONDS.sleep(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resultList.add("Task" + num + "执行完成");
            });
            futureList.add(task);
        }

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));

        try {
            allTasks.get(2, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | java.util.concurrent.TimeoutException e) {
            log.error("异步执行错误", e);
        }

        System.out.println("Result List: " + resultList);
    }
}
