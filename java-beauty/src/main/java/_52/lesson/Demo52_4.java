package _52.lesson;

/**
 * @Author lnd
 * @Description 基于中断异常终止线程
 * @Date 2024/5/11 00:29
 */
public class Demo52_4 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(count++);
                    try {
                        System.out.println("isInterrupted: " + Thread.currentThread().isInterrupted()); //false
                        Thread.sleep(5000); //当通过main线程向t1线程发起中断时，t1线程处于阻塞态。处于阻塞态的线程接收到中断请求后，会抛出InterruptedException异常并清除中断标志位
                    } catch (InterruptedException e) {
                        System.out.println("isInterrupted: " + Thread.currentThread().isInterrupted()); //false
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }, "Thread-t1");
        t1.start();
        Thread.sleep(1000);
        t1.interrupt(); //发起中断请求
    }
}
