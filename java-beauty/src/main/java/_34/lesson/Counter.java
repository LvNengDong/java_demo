package _34.lesson;

/**
 * @Author lnd
 * @Description
 * @Date 2024/5/11 22:50
 */
public class Counter {
    private int increasedSum = 0;
    private int decreasedSum = 0;
    private Object obj1 = new Object();
    private Object obj2 = new Object();

    public void add(int value) {
        synchronized (obj1) {
            increasedSum += value;
        }
    }

    public void substract(int value) {
        synchronized (obj2) {
            decreasedSum -= value;
        }
    }
}
