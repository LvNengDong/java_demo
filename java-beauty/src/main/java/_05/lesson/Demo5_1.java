package _05.lesson;

/**
 * @Author lnd
 * @Description
 * @Date 2024/5/14 20:16
 */
public class Demo5_1 {
    public static void main(String[] args) {
        int count = countOneBits(-3);
        System.out.println(count);
    }

    public static int countOneBits(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num >>>= 1;
        }
        return count;
    }
}
