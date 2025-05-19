package _20.lesson.bioDemo;

import java.io.IOException;
import java.net.Socket;

/**
 * @Author lnd
 * @Description
 * @Date 2024/10/4 23:20
 */
public class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        byte[] data = new byte[1024];
        while (true) { //持续接收客户端发来的数据
            try {
                // read()为阻塞函数，直到读取到数据再返回
                socket.getInputStream().read(data);
                // write()为阻塞函数，全部写完成才会返回
                socket.getOutputStream().write(data); // echo，写回给客户端
            } catch (IOException e) {
                // log and exit
                break;
            }
        }
    }
}
