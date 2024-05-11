package _30.lesson;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/26 10:29
 */
public class Demo30_1 {

    private static boolean running = true;
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    count++;
                }
                System.out.println("count: " + count);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                running = false;
            }
        });

        t1.start();
        Thread.sleep(1000); // 1s
        t2.start();
        t1.join();
        t2.join();
    }
}
