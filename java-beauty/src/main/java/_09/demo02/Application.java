package _09.demo02;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/19 15:21
 */
public class Application {
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(new B()).toPrintable());
    }
}
