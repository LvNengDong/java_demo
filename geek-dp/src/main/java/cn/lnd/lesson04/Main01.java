package cn.lnd.lesson04;

import java.util.*;

/**
 * @Author lnd
 * @Description
 * @Date 2025/2/12 00:01
 */
public class Main01 {

    public static void main(String[] args) {
        int res = new Main01().getMinCountsDPSol();
        System.out.println(res);
    }

    int getMinCountsDPSol() {
        int[] values = {3, 5}; // 硬币面值
        int total = 22; // 总值

        // 求得最小的硬币数量
        return getMinCounts(total, values); // 输出答案
    }

    int getMinCounts(int k, int[] values) {
        int[] memo = new int[k + 1];    // 下标0~22
        Arrays.fill(memo, -1);
        memo[0] = 0; // 初始化状态

        for (int v = 1; v <= k; v++) {
            int minCount = k + 1; // 模拟无穷大
            for (int i = 0; i < values.length; ++i) {
                int currentValue = values[i];
                // 如果当前面值大于硬币总额，那么跳过
                if (currentValue > v) {
                    continue;
                }
                // 使用当前面值，得到剩余硬币总额
                int rest = v - currentValue;
                int restCount = memo[rest];
                // 如果返回-1，说明组合不可信，跳过
                if (restCount == -1) {
                    continue;
                }
                // 保留最小总额
                int kCount = 1 + restCount;
                if (kCount < minCount) {
                    minCount = kCount;
                }
            }
            // 如果是可用组合，记录结果
            if (minCount != k + 1) {
                memo[v] = minCount;
            }
        }
        return memo[k];
    }
}
