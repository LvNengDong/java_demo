package lesson01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lnd
 * @Description
 * @Date 2024/6/25 15:03
 */
public class Demo_1 {
    private static final ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(() -> null);

    public static void main(String[] args) {
        Map wrong = new Demo_1().wrong(1);
        System.out.println(wrong);
    }

    public Map wrong(Integer userId) {
        //设置用户信息之前先查询一次ThreadLocal中的用户信息
        String before  = Thread.currentThread().getName() + ":" + currentUser.get();
        //设置用户信息到ThreadLocal
        currentUser.set(userId);
        //设置用户信息之后再查询一次ThreadLocal中的用户信息
        String after  = Thread.currentThread().getName() + ":" + currentUser.get();
        //汇总输出两次查询结果
        Map result = new HashMap();
        result.put("before", before);
        result.put("after", after);
        return result;
    }
}
