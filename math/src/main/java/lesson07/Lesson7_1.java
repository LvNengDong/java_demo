package lesson07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author lnd
 * @Description
 * @Date 2025/3/13 17:01
 */
public class Lesson7_1 {

    // 设置⻬王的⻢跑完所需时间
    public static HashMap<String, Double> q_horses_time = new HashMap<>() {
        {
            put("q1", 1.0);
            put("q2", 2.0);
            put("q3", 3.0);
        }
    };

    // 设置⽥忌的⻢跑完所需时间
    public static HashMap<String, Double> t_horses_time = new HashMap<>() {
        {
            put("t1", 1.5);
            put("t2", 2.5);
            put("t3", 3.5);
        }
    };

    public static ArrayList<String> q_horses = new ArrayList<>(Arrays.asList("q1", "q2", "q3"));


    /**
     * @Description: 使⽤函数的递归（嵌套）调⽤，找出所有可能的⻢匹出战顺序
     * @param horses ⽬前还剩多少⻢没有出战
     * @param result 保存当前已经出战的⻢匹及顺序
     */
    public static void permutate(ArrayList<String> horses, ArrayList<String> result) {
        // 所有⻢匹都已经出战，判断哪⽅获胜，输出结果
        if (horses.isEmpty()) {
            System.out.println(result);
            compare(result, q_horses);
            System.out.println();
            return;
        }

        for (int i = 0; i < horses.size(); i++) {
            // 从剩下的未出战⻢匹中，选择⼀匹，加⼊结果
            ArrayList<String> new_result = (ArrayList<String>) (result.clone());
            new_result.add(horses.get(i));
            // 将已选择的⻢匹从未出战的列表中移出
            ArrayList<String> rest_horses = ((ArrayList<String>) horses.clone());
            rest_horses.remove(i);
            // 递归调⽤，对于剩余的⻢匹继续⽣成排列
            permutate(rest_horses, new_result);
        }
    }

    public static void compare(ArrayList<String> t, ArrayList<String> q) {
        int t_won_cnt = 0;
        for (int i = 0; i < t.size(); i++) {
            System.out.println(t_horses_time.get(t.get(i)) + " " + q_horses_time.get(q.get(i)));
            if (t_horses_time.get(t.get(i)) < q_horses_time.get(q.get(i))) t_won_cnt++;
        }
        if (t_won_cnt > (t.size() / 2)) System.out.println("⽥忌获胜！");
        else System.out.println("⻬王获胜！");
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<String> horses = new ArrayList<>(Arrays.asList("t1", "t2", "t3"));
        Lesson7_1.permutate(horses, new ArrayList<>());
    }
}