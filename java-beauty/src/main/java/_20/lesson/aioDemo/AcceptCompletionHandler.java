package _20.lesson.aioDemo;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @Author lnd
 * @Description
 * @Date 2024/10/4 23:44
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {

    private AsynchronousServerSocketChannel serverChannel;

    public AcceptCompletionHandler(AsynchronousServerSocketChannel serverChannel) {
        this.serverChannel = serverChannel;
    }

    @Override
    public void completed(AsynchronousSocketChannel clientChannel, Object attachment) {
        // in order to accept other client's connections
        serverChannel.accept(attachment, this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 异步read()
        clientChannel.read(buffer, buffer, new ReadCompletionHandler(clientChannel));
    }

    @Override
    public void failed(Throwable exc, Object attachment) {
        // log exc exception
    }
}
