package _19.lesson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author lnd
 * @Description
 * @Date 2024/5/17 22:01
 */
public class Demo19_1 {
    public static void main(String[] args) {
        try (InputStream in = new FileInputStream("/Users/wangzheng/in.txt")) {
            byte[] data = new byte[1024];
            while (in.read(data) != -1) {
                //处理data数组...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
