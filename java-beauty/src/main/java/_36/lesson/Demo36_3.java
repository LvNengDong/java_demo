package _36.lesson;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author lnd
 * @Description
 * @Date 2024/5/11 01:15
 */
public class Demo36_3 {
    private Lock lock = new ReentrantLock();

    public void useTryLock() {
        if (lock.tryLock()) {
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
