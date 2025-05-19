package _54.lesson;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author lnd
 * @Description
 * @Date 2024/5/14 19:19
 */
public class Demo54_2 {
    private static final List<Integer> data = Arrays.asList(3, 4, 6, 2, 1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sumRes = 0;
                for (Integer d : data) sumRes += d;
                return sumRes;
            }
        });
        Integer sumRes = future.get();
        System.out.println(sumRes);
    }
}
