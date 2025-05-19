package cn.lnd;

/**
 * @Author lnd
 * @Description
 * @Date 2024/8/7 17:56
 */
public class Logback implements Log {
    @Override
    public void log(String info) {
        System.out.println("Logback:" + info);
    }

}
