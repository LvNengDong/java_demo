package _05.lesson;

import com.alibaba.fastjson2.JSON;

/**
 * @Author lnd
 * @Description 将十进制整数转换为十进制数组
 * @Date 2024/5/14 20:24
 */
public class Demo5_2 {

    public static void main(String[] args) {
        int a = 5194;
        int[] resArr = new Demo5_2().convertToDecimalArray(a);
        String jsonString = JSON.toJSONString(resArr);
        System.out.println(jsonString);
    }

    //a=5194 => {5,1,9,4}
    public int[] convertToDecimalArray(int a) {
        int[] arr = new int[10]; //int类型最大2147483647，10位数
        int i = 0;
        while (a != 0) {
            arr[i] = a % 10; //余数放入数组 {4,9,1,5}
            a = a / 10; //商重新赋值给a
            i++;
        }
        swap(arr, i); //将{4,9,1,5}翻转为{5,1,9,4}
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
