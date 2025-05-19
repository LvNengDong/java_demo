package cn.lnd.lesson03;

import java.util.Arrays;

/**
 * @Author lnd
 * @Description 使用备忘录求解硬币找零问题
 * @Date 2025/2/11 17:22
 */
public class Main02 {
    public static void main(String[] args) {
        int res = new Main02().getMinCountsSol();
        System.out.println(res);
    }

    int getMinCountsSol() {
        int[] values = {3, 5}; // 硬币面值
        int total = 14; // 总值
        int[] memo = new int[total + 1]; // 备忘录，备忘录数组中数据的含义：索引n位置上存储的数据表示当前余额为n时最小硬币数量
        Arrays.fill(memo, -2);  // 没有缓存的元素为-2
        memo[0] = 0; // 其中0对应的结果也是0，首先存在备忘录中

        // 求得最小的硬币数量，并输出结果
        return getMinCountsHelper(total, values, memo); // 输出结果
    }


    int getMinCountsHelper(int total, int[] values, int[] memo) {
        int savedMinCount = memo[total];
        if (savedMinCount != -2) {  // 从备忘录中取数据，如果数据不为初始值，表示备忘录中的数据是有效数据，无需计算，直接返回即可。如果备忘录中的数据为初始值，表示需要计算一遍，计算完成后需要将计算值加到备忘录中
            return savedMinCount;
        }


        int valueLength = values.length;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < valueLength; i++) { // 遍历所有面值
            int currentValue = values[i];
            // 如果当前面值大于硬币总额，那么跳过
            if (currentValue > total) {
                continue;
            }

            // 使用当前面值，得到剩余硬币总额
            int rest = total - currentValue;
            int restCount = getMinCountsHelper(rest, values, memo);
            // 如果返回-1，说明组合不可信，跳过
            if (restCount == -1) {
                continue;
            }

            // 保留最小总额
            int totalCount = 1 + restCount;
            if (totalCount < minCount) {
                minCount = totalCount;
            }
        }

        // 如果没有可用组合，返回-1
        if (minCount == Integer.MAX_VALUE) {
            memo[total] = -1;
            return -1;
        }

        memo[total] = minCount; // 记录到备忘录
        return minCount; // 返回最小硬币数量
    }
}
