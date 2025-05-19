package cn.lnd.lesson08;

/**
 * @Author lnd
 * @Description 回文串
 * @Date 2025/2/21 14:49
 */
public class Main01 {

    public static void main(String[] args) {

    }

    int countSubstrings(String s) {
        int n = s.length();
        if (0 == n) {
            return 0;
        }

        int ans = 0;

        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans++;
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1] || j - i < 3);
                if (dp[i][j]) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
