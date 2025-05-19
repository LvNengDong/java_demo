package cn.lnd.lesson10;

/**
 * @Author lnd
 * @Description 跳跃游戏
 * <p>
 * 题目：给出一个非负整数数组 A，你最初定位在数组的第一个位置。数组中的每个元素代表你在那个位置可以跳跃的最大长度。判断你是否能到达数组的最后一个位置。
 * <p>
 * 示例1：
 * <p>
 * 输入：A = [2,3,1,1,6]
 * 输出：True
 * 解释: 我们可以先跳1步，从位置0到达位置1, 然后再从位置1跳3步到达最后一个位置。
 * <p>
 * 示例2：
 * <p>
 * 输入：A = [4,2,1,0,0,6]
 * 输出：False
 * 解释: 无论从开头怎么跳跃，你最多都只能到达位置3或位置4，但这两个位置的最大跳跃长度是0，所以你永远不可能到达最后一个位置。
 * @Date 2025/2/28 11:03
 */
public class Main03 {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n < 1) {
            return true;
        }
        boolean[] dp = new boolean[n];
        // 初始化dp
        for (int i = 0; i < n; i++) {
            dp[i] = false;
        }
        dp[0] = true;

        // 状态转移方程
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}
