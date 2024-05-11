package lg._53.demo01;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 00:52
 */
public class RunDemo2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("运动员有5秒的准备时间");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            final int no = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(no + "号运动员准备完毕，等待裁判员的发令枪");
                    try {
                        countDownLatch.await();
                        System.out.println(no + "号运动员开始跑步了");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            service.submit(runnable);
        }
        for (int i = 5; i > 0; i--) {
            System.out.println(i + "!");
            Thread.sleep(1000); // 裁判倒数5s
        }
        System.out.println("5秒准备时间已过，发令枪响，比赛开始！");
        countDownLatch.countDown();
    }
}
