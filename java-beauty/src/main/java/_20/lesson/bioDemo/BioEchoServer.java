package _20.lesson.bioDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author lnd
 * @Description
 * @Date 2024/10/4 23:18
 */
public class BioEchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("127.0.0.1", 1192));
        while (true) {
            // accept() 为阻塞函数，直到有连接到来才返回
            Socket clientSocket = serverSocket.accept();
            // 为了每个客户端单独创建一个线程处理
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }
}
