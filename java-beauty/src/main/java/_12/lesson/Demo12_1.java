package _12.lesson;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lnd
 * @Description
 * @Date 2024/6/16 23:54
 */
public class Demo12_1 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(); //或new ArrayList<>();
        list.add(3);
        list.add(6);
        list.add(2);
        testComparable(list);
        System.out.println("================");
        testComparator(list);
    }

    private static void testComparable(List<Integer> list) {
        Collections.sort(list);
        for (Integer i : list) {
            System.out.println(i); //输出2、3、6
        }
    }

    private static void testComparator(List<Integer> list) {
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (Integer i : list) {
            System.out.println(i); //输出6、3、2
        }
    }
}
