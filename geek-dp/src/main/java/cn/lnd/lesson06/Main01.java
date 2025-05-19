package cn.lnd.lesson06;

/**
 * @Author lnd
 * @Description 问题：给你一个可放总重量为W的背包和N个物品，对每个物品，有重量w和价值v两个属性，那么第i个物品的重量为w[i]，价值为v[i]。
 * 现在让你用这个背包装物品，问最多能装的价值是多少？
 * @Date 2025/2/12 17:07
 */
public class Main01 {
    public static void main(String[] args) {
        int res = new Main01().solveDP();
        System.out.println(res);
    }

    /**
     * @param w 物品的重量
     * @param v 物品的价值
     * @param N 物品的总数
     * @param W 背包能容纳的重量
     * @return
     */
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
        int N = 3;  // 物品的总数
        int W = 5;  // 背包能容纳的总重量（背包只限制重量不限制物品数量）
        int[] w = {0, 3, 2, 1}; // 物品的重量
        int[] v = {0, 5, 2, 3}; // 物品的价值
        return dp(w, v, N, W);
    }
}
