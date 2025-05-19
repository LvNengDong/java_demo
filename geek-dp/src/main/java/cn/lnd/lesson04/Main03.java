package cn.lnd.lesson04;

import java.util.Arrays;

/**
 * @Author lnd
 * @Description
 *      leetcode 53
 *      如果给你一个包含正数和负数的整数数组，你能否找到一个具有最大和的连续子数组，其中子数组最少包含一个元素，返回其最大和。
 *      比如输入的子数组是 [-2, 1, -3, 1, -1, 6, 2, -5, 4]，输出是 8，因为连续子数组 [1, -1, 6, 2] 的和最大。
 * @Date 2025/2/12 21:30
 */
public class Main03 {
    public static void main(String[] args) {
        int[] nums = new int[] {-2, 1, -3, 1, -1, 6, 2, -5, 4};
        int res = dp(nums);
        System.out.println(res);
    }

    public static int dp(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        int maxVal = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxVal = Math.max(dp[i], maxVal);
        }
        return maxVal;
    }
}
