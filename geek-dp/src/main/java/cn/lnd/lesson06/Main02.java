package cn.lnd.lesson06;

/**
 * @Author lnd
 * @Description https://leetcode.cn/problems/last-stone-weight-ii/description/
 * 问题：有一堆石头，每块石头的重量都是正整数。每次从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为x和y，且x≤y。那么粉碎的可能结果如下：
 *  1. 如果x与y相等，那么两块石头都会被完全粉碎；
 *  2. 否则，重量为x的石头将会完全粉碎，而重量为y的石头的新重量为y−x。
 * 最后，最多只会剩下一块石头。返回此时石头最小的可能重量。如果没有石头剩下，就返回 0。
 * @Date 2025/2/12 17:07
 */
public class Main02 {
    public static void main(String[] args) {
        int res = new Main02().solveDP();
        System.out.println(res);
    }

    int dp(int[] w, int[] v, int N, int W) {
        // 创建备忘录
        // DP[tn][rw]  行代表tn，表示第几个物品；列代表rw，表示背包还能通纳的重量。
        // 比如DP[2][3]）对应位置的值，就是这个子问题的答案，表示当背包还能容纳 3 的重量时，放入前2件物品的最大价值。
        int[][] dp = new int[N+1][W+1];
        // 初始化状态
        for (int i = 0; i < N + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < W + 1; j++) {
            dp[0][j] = 0;
        }
        for (int tn = 1; tn < N + 1; tn++) { // 遍历每一件物品
            for (int rw = 1; rw < W + 1; rw++) { // 背包容量有多大就还要计算多少次
                if (rw < w[tn]) {
                    // 当背包容量小于第tn件物品重量时，只能放入前tn-1件
                    dp[tn][rw] = dp[tn - 1][rw];
                } else {
                    // 当背包容量还大于第tn件物品重量时，进一步作出决策
                    dp[tn][rw] = Math.max(dp[tn - 1][rw], dp[tn - 1][rw - w[tn]] + v[tn]);
                }
            }
        }
        return dp[N][W];
    }

    int solveDP() {
        int N = 6;  // 物品的总数
        int W = 12;  // 背包能容纳的总重量（背包只限制重量不限制物品数量）
        int[] w = {1,2,1,7,9,4}; // 物品的重量
        int[] v = {1,2,1,7,9,4}; // 物品的价值
        return dp(w, v, N, W);
    }
}
