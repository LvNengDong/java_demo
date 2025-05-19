package _54.lesson;

import java.util.Arrays;
import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2024/5/14 19:19
 */
public class Demo54_1 {
    private static final List<Integer> data = Arrays.asList(3, 4, 6, 2, 1);
    private static int sumRes = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread sumThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Integer d : data) {
                    sumRes += d;
                }
            }
        });
        sumThread.start();
        // 阻塞main线程，等待sumThread线程执行完毕
        sumThread.join();
        System.out.println(sumRes);
    }
}
