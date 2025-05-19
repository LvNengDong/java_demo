package _05.lesson;

import com.alibaba.fastjson2.JSON;

import java.util.Arrays;

/**
 * @Author lnd
 * @Description
 * @Date 2024/5/14 20:24
 */
public class Demo5_4 {

    public static void main(String[] args) {
        int[] binaryArr = {1,0,1,1};
        int res = new Demo5_4().convertToDecimal(binaryArr, binaryArr.length);
        System.out.println(res);
    }

    /**
     * 将二进制数组转化成十进制整数
     *      {1, 0，1， 1} -》1011（二进制表示），k=4表示二进制位个数
     * @param binaryArr
     * @return
     */
    public int convertToDecimal(int[] binaryArr, int k) {
        int weight = 1; // 权重
        int a = 0;
        for (int i = k-1; i >= 0; i--) {
            a = a + binaryArr[i] * weight;
            weight = weight * 2;
        }
        return a;
    }
}
