package _20.lesson.aioDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;

/**
 * @Author lnd
 * @Description
 * @Date 2024/10/4 23:42
 */
public class AioEchoServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress("127.0.0.1", 1192));
        // 异步accept()
        serverChannel.accept(null, new AcceptCompletionHandler(serverChannel));
        Thread.sleep(Integer.MAX_VALUE);
    }
}
