package _36.lesson;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author lnd
 * @Description
 * @Date 2024/5/11 00:57
 */
public class Demo36_1 {
    Lock lock = new ReentrantLock();
    private int seq = 0;

    public int getEvenSeq() {
        lock.lock();
        try {
            // ...省略其他操作...
            if (seq % 2 == 1) {
                increment();
            }
            return seq;
        } finally {
            lock.unlock();
        }
    }

    public void increment() {
        lock.lock();
        seq++;
        lock.unlock();
    }
}
