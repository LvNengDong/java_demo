package _36.lesson;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author lnd
 * @Description
 * @Date 2024/5/11 01:06
 */
public class Demo36_2 {
    private static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lockInterruptibly();

                } catch (InterruptedException e) {
                    System.out.println("I am interrupted");
                    return;
                }
                try {
                    System.out.println("I got lock");
                } finally {
                    // 获取锁成功才需要释放锁，获取锁被中断时不需要释放锁
                    lock.unlock();
                }
            }
        });
        lock.lock(); // 1、主线程获取到锁并一直持有
        t1.start(); // 2、t1线程调用lockInterruptibly()请求锁（因为锁被主线程持有，所以，线程t1阻塞等待）
        t1.interrupt(); //3、主线程调用interrupt()函数向线程t1发起中断请求（线程t1响应中断请求，退出阻塞等待锁，并打印“I am interrupted”）
        lock.unlock();
    }
}
