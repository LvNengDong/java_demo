package cn.lnd.lesson10;

/**
 * @Author lnd
 * @Description
 * @Date 2025/2/28 09:50
 */
public class Main01 {
    public static void main(String[] args) {

    }

    int getPathCount(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化dp
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 状态转移方程
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

}
