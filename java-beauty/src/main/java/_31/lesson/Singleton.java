package _31.lesson;

import lombok.Data;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/26 21:14
 */
public class Singleton {

    private static Singleton instance;

    private final int seq;

    private Singleton(int seq) {
        this.seq = seq;
    }

    public static Singleton getInstance() {

        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(11);
                }
            }
        }
        return instance;
    }

    // 省略其他方法，比如seq的getter方法
}
