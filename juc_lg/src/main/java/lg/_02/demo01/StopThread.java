package lg._02.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/9 22:54
 */
public class StopThread implements Runnable{

    /**
     * 这段业务代码的含义是：打印 0~1000 之间的所有数字
     *      如果执行的过程中没有被通知中断，可以正常打印完全部数字；
     *      但是如果接收到了中断信号，会在每次循环开始的判断条件中进行判断，如果需要中断，就放弃执行后面的任务，让线程自行结束，释放资源
     */
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted() && count < 1000) {
            System.out.println("count=" + count++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThread());
        thread.start();
        Thread.sleep(5); // sleep 5ms
        thread.interrupt();
    }
}
