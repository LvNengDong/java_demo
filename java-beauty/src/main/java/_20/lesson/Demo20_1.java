package _20.lesson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

/**
 * @Author lnd
 * @Description
 * @Date 2024/10/4 22:14
 */
public class Demo20_1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URI resourcePath = classLoader.getResource("in.txt").toURI();
        FileChannel channel = FileChannel.open(Paths.get(resourcePath));
        ByteBuffer buffer = ByteBuffer.allocate(521);
        while (channel.read(buffer) != -1) {
             //处理 buffer 中的数据 data
            for (byte b : buffer.array()) {
                System.out.println(b);
            }
        }
    }
}
