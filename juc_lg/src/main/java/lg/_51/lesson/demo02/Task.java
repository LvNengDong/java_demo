package lg._51.lesson.demo02;

import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/18 21:31
 */
public class Task implements Runnable {

    Integer productId;
    Set<Integer> prices;
    CountDownLatch countDownLatch;

    public Task(Integer productId, Set<Integer> prices, CountDownLatch countDownLatch) {
        this.productId = productId;
        this.prices = prices;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        int price = 0;
        try {
            Thread.sleep((long) (Math.random() * 4000));
            price = (int) (Math.random() * 4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        prices.add(price);
        countDownLatch.countDown();
    }
}
