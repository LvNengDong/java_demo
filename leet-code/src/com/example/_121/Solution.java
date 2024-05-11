package com.example._121;

/**
 * @Author lnd
 * @Description 121.买卖股票的最佳时机（简单）
 *  贪心思想：保持在最便宜的时候买入，最贵的时候卖出，即可获取最大的利润
 *
 *  link： https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-100-liked
 * @Date 2024/4/27 12:00
 */
public class Solution {
    public static void main(String[] args) {
        int[] prices = {2, 7, 1, 4, 6, 4};
        int i = new Solution().maxProfit(prices);
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];
        for (int curPrice : prices) {
            if (curPrice <= buyPrice) {
                // 如果当天价格低于之前的价格，则是新的买入点
                buyPrice = curPrice;
            } else {
                // 如果当天价格高于之前的价格，则是拥有收益的一天。记录一个最大收益
                maxProfit = Math.max(maxProfit, curPrice - buyPrice);
            }
        }
        return maxProfit;
    }
}
