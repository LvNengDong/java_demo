package _20.lesson.aioDemo;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @Author lnd
 * @Description
 * @Date 2024/10/4 23:47
 */
public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel clientChannel;

    public ReadCompletionHandler(AsynchronousSocketChannel clientChannel) {
        this.clientChannel = clientChannel;
    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        buffer.flip();
        // 异步write()。回调函数为null，写入完成就不用回调了
        clientChannel.write(buffer, null, null); // echo
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        // log exc exception
    }
}
