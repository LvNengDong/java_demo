package _09.demo01;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/19 14:44
 */
public class Demo9_1 {
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(new MyObject()).toPrintable());
    }
}
