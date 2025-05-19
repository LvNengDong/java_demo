package _07.lesson;

/**
 * @Author lnd
 * @Description
 * @Date 2024/6/19 14:47
 */
public class Demo7_1 {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
    }

    private static void test04() {
        char ch = 97;
        System.out.println(ch); //打印：a
    }

    private static void test03() {
        char invisibleC4 = '\n'; //换行的转移字符为\n
        System.out.println("abc\ndef"); //一行打印abc，另一行打印def
    }

    public static void test02() {
        char invisibleC3 = '\012'; //换行的ASCII为10，八进制012
        System.out.println("abc\012def"); //一行打印abc，另一行打印def
    }

    public static void test01() {
        char visibleC1 = 'a';
        char visibleC2 = '\141'; //a的ASCII为97，八进制141
        System.out.println(visibleC2); //打印a
    }
}
