package cn.lnd;

/**
 * @Author lnd
 * @Description
 * @Date 2024/8/7 17:57
 */
public class Log4j implements Log{
    @Override
    public void log(String info) {
        System.out.println("Log4j:" + info);
    }
}
