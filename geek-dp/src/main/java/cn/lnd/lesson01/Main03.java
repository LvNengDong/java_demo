package cn.lnd.lesson01;

import java.util.Arrays;

/**
 * @Author lnd
 * @Description
 * @Date 2025/2/6 20:02
 */
public class Main03 {
    public static void main(String[] args) {
        new Main03().getMinCoinCount();
    }

    private void getMinCoinCount() {
        int[] values = {5, 2, 1};  // 硬币面值
        int total = 11; // 总价
        int minCoinCount = getMinCoinCountHelper(total, values);
        System.out.println(minCoinCount);
    }

    /**
     * @param total 金额
     * @param coins 币种数组，已经有序，从大到小排序
     * @return 返回硬币数量，如果返回-1表示无法凑够 total
     */
    private int getMinCoinCountHelper(int total, int[] coins) {
        if (coins.length == 0) {
            return -1;
        }
        int curCoin = coins[0];    // 当前硬币面值
        int useCurCoinCount = total / curCoin;  // 使用当前币值的数量
        int restTotal = total - useCurCoinCount * curCoin;  // 剩余金额
        // 如果 restTotal 为 0，表示余额已除尽，组合完成
        if (restTotal == 0) {
            return useCurCoinCount;
        }
        // 其它币种数量
        int coinCount = 0;
        // 剩余的币种
        int[] restCoins = Arrays.copyOfRange(coins, 1, coins.length);
        while (useCurCoinCount > 0) {  // 如果 useCurCoinCount <= 0，表明剩余的最小币种也满足不了条件
            // 尝试使用剩余面值求当前余额的硬币总数
            coinCount = getMinCoinCountHelper(restTotal, restCoins);
            if (coinCount == -1) {  // 如果后续没有可用组合，回溯一步，当前 useCurCoinCount 数量减1
                useCurCoinCount--;
                // 重新计算 restTotal
                restTotal = total - useCurCoinCount * curCoin;
            } else {
                return useCurCoinCount + coinCount;
            }
        }
        return -1;
    }
}
