package _53.lesson;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author lnd
 * @Description
 * @Date 2024/5/13 22:21
 */
public class Demo53_1 {

    public static void main(String[] args) throws InterruptedException {
        // 创建与配置
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                5, 10, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(15),
                new ThreadFactory() {
                    private final AtomicInteger idx = new AtomicInteger(1);
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "pool-" + idx.getAndIncrement());
                    }
                }, new ThreadPoolExecutor.DiscardPolicy());

        // 执行
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world!");
            }
        });

        // 关闭
        pool.shutdown(); // 发起关闭请求
        boolean terminated = false;
        while (!terminated) {
            // 返回false表示超时，返回true表示线程池真正关闭
            terminated = pool.awaitTermination(100, TimeUnit.SECONDS);
        }
        System.out.println("pool is shutdown.");
    }
}
