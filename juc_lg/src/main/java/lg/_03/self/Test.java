package lg._03.self;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/23 21:11
 */
public class Test {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "-我是一个子线程");
            }
        };
        Thread subThread = new Thread(task);
        System.out.println("Thread State: " + subThread.getState());
        subThread.start();
        System.out.println("Thread State: " + subThread.getState());

    }
}
