package lg._51.lesson.demo01;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author lnd
 * @Description 有超时的并行获取01：线程池实现
 *      缺点：等待的时间是固定的，如果3个Task的响应时间都很快，main线程大部分时间都是白等的
 * @Date 2024/4/18 21:30
 */
public class ThreadPoolDemo {

    ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
        System.out.println(threadPoolDemo.getPrices());
    }

    private Set<Integer> getPrices() throws InterruptedException {
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<Integer>());
        threadPool.submit(new Task(123, prices));
        threadPool.submit(new Task(456, prices));
        threadPool.submit(new Task(789, prices));
        Thread.sleep(3000); // main线程等待3s，3s后直接继续往下执行，此时 Set 中有多少个值是未知的，如果3个Task在3s内都执行完成了，Set中就有3个值，如果只有2个Task在3s内完成了，1个Task没有完成，则Set中只有2个值
        return prices;
    }
}
