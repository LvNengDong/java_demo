package _52.lesson;

/**
 * @Author lnd
 * @Description 无视中断请求
 * @Date 2024/5/11 00:27
 */
public class Demo52_3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (true) { // 无视中断
                    System.out.println(count++);
                }
            }
        }, "Thread-t1");
        t1.start();
        Thread.sleep(100);
        t1.interrupt(); //发起中断请求
    }
}
