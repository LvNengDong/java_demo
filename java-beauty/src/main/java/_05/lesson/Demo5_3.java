package _05.lesson;

import com.alibaba.fastjson2.JSON;

/**
 * @Author lnd
 * @Description 将十进制整数转换为二进制数组
 * @Date 2024/5/14 20:24
 */
public class Demo5_3 {

    public static void main(String[] args) {
        int a = 11;
        int[] resArr = new Demo5_3().convertToBinaryArray(a);
        String jsonString = JSON.toJSONString(resArr);
        System.out.println(jsonString);
    }

    //a=1011（二进制表示） => {1，0，1，1}
    public int[] convertToBinaryArray(int a) {
        int[] arr = new int[32];
        int i = 0;
        while (a != 0) {
            arr[i] = a % 2; //余数放入数组 {1,1,0,1}
            a = a / 2; //商重新赋值给a
            i++;
        }
        swap(arr, i); // 数组翻转
        return arr;
    }

    public void swap(int[] arr, int n) {
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
