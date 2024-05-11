package _52.lesson;

import java.text.MessageFormat;

/**
 * @Author lnd
 * @Description 基于标志终止线程
 * @Date 2024/5/11 00:17
 */
public class Demo52_1 {

    private static volatile boolean stopped = false;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (!stopped) {
                    System.out.println(count++);
                }
                System.out.println(MessageFormat.format("线程正常退出 {0}", Thread.currentThread().getName()));
            }
        }, "Thread-t1");
        t1.start();
        Thread.sleep(1000);
        stopped = true;
    }
}
