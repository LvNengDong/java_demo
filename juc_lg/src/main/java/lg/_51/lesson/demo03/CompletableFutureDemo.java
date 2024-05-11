package lg._51.lesson.demo03;


import lg._51.lesson.demo01.Task;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @Author lnd
 * @Description 有超时的并行获取03：CompletableFuture实现
 * @Date 2024/4/18 21:43
 */
public class CompletableFutureDemo {

    ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        CompletableFutureDemo completableFutureDemo = new CompletableFutureDemo();
        System.out.println(completableFutureDemo.getPrices());
    }

    private Set<Integer> getPrices() {
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<Integer>());
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(new Task(123, prices), threadPool);
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(new Task(456, prices), threadPool);
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(new Task(789, prices), threadPool);
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
        try {
            allTasks.get(3, TimeUnit.SECONDS); // 使用 CompletableFuture#get() 进行计时等待，超时的结果不等
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            throw new RuntimeException(e);
        }
        return prices;
    }
}
