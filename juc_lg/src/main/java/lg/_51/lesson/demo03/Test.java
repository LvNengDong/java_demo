package lg._51.lesson.demo03;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/22 16:13
 */
public class Test {
    static ExecutorService threadPool = Executors.newFixedThreadPool(3);
    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        CopyOnWriteArrayList<Integer> resList = Lists.newCopyOnWriteArrayList(); // 线程安全
        List<CompletableFuture<Void>> futures = Lists.newArrayList();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            CompletableFuture<Void> task = CompletableFuture.runAsync(() -> {
                System.out.println("assdasda");
                resList.add(finalI);
            }, threadPool);
            futures.add(task);
        }
        CompletableFuture<Void>[] futuresArray = futures.toArray(new CompletableFuture[0]);
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futuresArray);
        try {
            allTasks.get();
        } catch (InterruptedException | ExecutionException e) {

        }

        System.out.println(resList);
    }
}
