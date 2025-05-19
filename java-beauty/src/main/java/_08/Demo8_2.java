package _08;

/**
 * @Author lnd
 * @Description
 * @Date 2024/12/9 16:33
 */
public class Demo8_2 {
    public static void main(String[] args) {
        String latinS = "abc";
        System.out.println("" + latinS.getBytes().length);
        String utf16S = "王abc争";
        System.out.println("" + utf16S.getBytes().length);
    }
}
