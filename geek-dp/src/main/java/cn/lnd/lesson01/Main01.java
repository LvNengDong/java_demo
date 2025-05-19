package cn.lnd.lesson01;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author lnd
 * @Description
 * @Date 2025/2/6 10:29
 */
public class Main01 {
    public static void main(String[] args) {
        System.out.println(new Main01().getMinCoinCount());
    }

    int getMinCoinCount() {
        int[] values = {5, 3};  // 硬币面值
        int total = 11; // 总价
        return getMinCoinCountHelper(total, values, 2);
    }


    private int getMinCoinCountHelper(int total, int[] values, int valueCount) {
        int rest = total;
        int count = 0;
        // 从大到小遍历所有面值【这里要求所有面值按从大到小排序，因为数组中的元素是从第一个开始取的，否则无法贪心】
        for (int i = 0; i < valueCount; i++) {
            int curCount = rest / values[i];   // 计算当前面值最多能使用多少个
            rest = rest - curCount * values[i]; // 计算使用完当前面值后的余额
            count = count + curCount;   // 增加当前面额用量
            if (rest == 0) {
                return count;
            }
        }
        return -1; // 如果到这里说明无法凑出总价，返回-1
    }
}
