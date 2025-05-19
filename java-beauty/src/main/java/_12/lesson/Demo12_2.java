package _12.lesson;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2024/6/17 00:14
 */
public class Demo12_2 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(6);
        list.add(2);
        // Comparator接口的匿名类对象对null。使用 Integer实现的 Comparable 接口进行元素大小比较
        list.sort(null);
        for (Integer i : list) {
            System.out.println(i); //输出2、3、6
        }
    }
}
