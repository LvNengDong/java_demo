import java.util.concurrent.ExecutorService;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/18 16:06
 */
public class Test {
    public static void main(String[] args) {
        int CPU_CORE_COUNT = 5;
        final double THREAD_MULTI_RATE = 1.5;
        int i = (int) (CPU_CORE_COUNT * THREAD_MULTI_RATE);
        double v = CPU_CORE_COUNT * THREAD_MULTI_RATE;
        System.out.println(i);
        System.out.println(v);
    }
}
