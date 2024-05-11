package lg._51.lesson.demo01;

import java.util.Set;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/18 21:31
 */
public class Task implements Runnable {

    Integer productId;
    Set<Integer> prices;

    public Task(Integer productId, Set<Integer> prices) {
        this.productId = productId;
        this.prices = prices;
    }

    @Override
    public void run() {
        int price = 0;
        //try {
            //Thread.sleep((long) (Math.random() * 4000));
            price = (int) (Math.random() * 4000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        prices.add(price);
    }
}
