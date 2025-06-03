package other;

/**
 * @Author lnd
 * @Description
 * com.alibaba.ttl.TransmittableThreadLocal 类解释
 * com.alibaba.ttl.TransmittableThreadLocal（简称 TTL） 是阿里巴巴开源的一个扩展类，用于解决线程池环境下 ThreadLocal 与 InheritableThreadLocal 值传递的问题。
 *
 * 背景
 * ThreadLocal 只能在当前线程中存储和获取值，无法在子线程中获取；InheritableThreadLocal 虽能在创建子线程时将值从父线程传递到子线程，但在使用线程池时，由于线程池中的线程是复用的，不会重新创建，InheritableThreadLocal 无法将值传递到线程池中的线程。TransmittableThreadLocal 就是为了解决这个问题而设计的。
 *
 * 主要特性
 * 线程池环境下的值传递：能够在提交任务的线程和执行任务的线程之间传递值，即使线程是从线程池中复用的。
 * 可禁用继承能力：可以通过配置或重写方法来禁用从父线程继承值的能力，避免潜在的内存泄漏问题。
 * 支持回调方法：提供 beforeExecute 和 afterExecute 回调方法，可在任务执行前后执行自定义逻辑。
 *
 * @Date 2025/6/3 21:06
 */
import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransmittableThreadLocalExample {
    // 创建 TransmittableThreadLocal 实例
    private static final TransmittableThreadLocal<String> ttl = new TransmittableThreadLocal<>();

    public static void main(String[] args) {
        // 在主线程中设置 TransmittableThreadLocal 的值
        ttl.set("Value from main thread");

        // 创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // 创建一个可传递 TTL 值的 Runnable 任务
        Runnable task = TtlRunnable.get(() -> {
            // 在子线程中获取 TransmittableThreadLocal 的值
            System.out.println("Value in child thread: " + ttl.get());

            // 在子线程中修改 TransmittableThreadLocal 的值
            ttl.set("Modified value in child thread");
            System.out.println("Modified value in child thread: " + ttl.get());
        });

        // 提交任务到线程池
        executorService.submit(task);

        // 关闭线程池
        executorService.shutdown();

        // 在主线程中再次获取 TransmittableThreadLocal 的值
        System.out.println("Value in main thread after child thread execution: " + ttl.get());
    }
}
