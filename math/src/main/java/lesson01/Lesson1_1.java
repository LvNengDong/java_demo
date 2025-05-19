package lesson01;

import java.math.BigInteger;

/**
 * @Author lnd
 * @Description
 * @Date 2025/3/13 12:22
 */
public class Lesson1_1 {

    /**
     * - @Description:⼗进制转换成⼆进制
     * - @param decimalSource
     * - @return String
     */
    public static String decimalToBinary(int decimalSource) {
        BigInteger bi = new BigInteger(String.valueOf(decimalSource)); //转换成BigInteger类型，默认是⼗进制
        return bi.toString(2); //参数2指定的是转化成⼆进制
    }

    /**
     * - @Description:⼆进制转换成⼗进制
     * - @param binarySource
     * - @return int
     */
    public static int binaryToDecimal(String binarySource) {
        BigInteger bi = new BigInteger(binarySource, 2);//转换为BigInteger类型，参数2指定的是⼆进制
        return Integer.parseInt(bi.toString());//默认转换成⼗进制
    }


    public static void main(String[] args) {
        int a = 53;
        String b = "110101";
        System.out.println(String.format("数字%d的⼆进制是%s", a, Lesson1_1.decimalToBinary(a))); //获取⼗进制数53的⼆
        System.out.println(String.format("数字%s的⼗进制是%d", b, Lesson1_1.binaryToDecimal(b))); //获取⼆进制数11010
    }
}