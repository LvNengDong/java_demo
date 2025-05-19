package cn.lnd.lesson08;

/**
 * @Author lnd
 * @Description
 * @Date 2025/2/21 15:12
 */
public class Main02 {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 3, -5, 1, 2};
        int[] dp = new int[1];
        int res = new Main02().maxSum(arr, dp);
        System.out.println(res);
    }

    public int maxSum(int[] arr, int[] dp) {
        if (arr.length == 0) {
            return 0;
        }
        dp[0] = arr[0];
        int res = dp[0];
        if (arr.length == 1) {
            return arr[0];
        }
        for (int i = 1; i < arr.length; i++) {
            dp[0] = Math.max(arr[i], dp[0] + arr[i]);
            res = Math.max(res, dp[0]);
        }
        return dp[0];
    }
}
