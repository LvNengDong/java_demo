package lg._02.demo02;

/**
 * @Author lnd
 * @Description 主线程休眠 5 毫秒后，通知子线程中断，此时子线程仍在执行 sleep 语句，处于休眠中
 * @Date 2024/4/9 23:04
 */
public class StopDuringSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                int count = 0;
                try {
                    while (!Thread.currentThread().isInterrupted() && count < 1000) {
                        System.out.println("count=" + count);
                        count++;
                        Thread.sleep(100000); // 子线程睡眠100000ms
                    }
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().isInterrupted());
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();

        Thread.sleep(500); // 主线程睡眠5ms

        thread.interrupt();
    }
}
