package cn.lnd.lesson07;

/**
 * @Author lnd
 * @Description
 * @Date 2025/2/21 11:17
 */
public class Main01 {
    public static void main(String[] args) {
        System.out.println(new Main01().solveBag());
    }

    int solveBag() {
        int N = 3, W = 5; // 物品的总数，背包能容纳的总重量
        int[] w = {0,3,2,1};    // 物品的重量
        int[] v = {0,3,2,1};    // 物品的价值
        return bag(w, v, N, W);
    }

    int bag(int[] w, int[] v, int N, int W) {
        // 创建备忘录
        int[][] dp = new int[N + 1][W + 1];

        // 初始化状态
        for (int i = 0; i < N + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < W + 1; j++) {
            dp[0][j] = 0;
        }

        // 遍历每一件物品
        for (int tn = 1; tn < N + 1; tn++) {
            // 背包容量有多大就还要计算多少次
            for (int rw = 1; rw < W + 1; rw++) {
                dp[tn][rw] = dp[tn-1][rw];
                // 根据rw尝试放入多次物品，从中找出最大值，作为当前子问题的最优解
                for (int k = 0; k <= rw/w[tn]; k++) {
                    dp[tn][rw] = Math.max(dp[tn][rw], dp[tn-1][rw-k*w[tn] + k*v[tn]]);
                }
            }
        }
        return dp[N][W];
    }
}
