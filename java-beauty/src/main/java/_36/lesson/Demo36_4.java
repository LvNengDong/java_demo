package _36.lesson;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author lnd
 * @Description
 * @Date 2024/5/11 01:18
 */
public class Demo36_4 {
    private Lock lock = new ReentrantLock();

    public void useTryLockWithTimeout() {
        boolean locked = false;
        try {
            locked = lock.tryLock(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println("I am interrupted");
        }
        if (locked) {
            try {
                // ...执行业务代码...
            } finally {
                lock.unlock();
            }
        } else {
            // ...没有获取锁，执行其他业务代码...
        }
    }
}
