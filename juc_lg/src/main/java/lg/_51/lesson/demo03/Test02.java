package lg._51.lesson.demo03;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author lnd
 * @Description
 * @Date 2024/8/20 15:53
 */
public class Test02 {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("aaa");
        CompletableFuture<Void> future = CompletableFuture.runAsync(
                () -> getListData(buffer));
        try {
            future.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println("e = " + e);
            throw new RuntimeException("异步超时");
        }

        System.out.println("buffer = " + buffer.toString());
    }

    private static void getListData(StringBuffer buffer) {
        try {
            Thread.sleep(3000);
            buffer.append("bbb");
        } catch (InterruptedException e) {

        }
    }
}
