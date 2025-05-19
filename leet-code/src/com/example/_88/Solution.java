package com.example._88;

/**
 * @Author lnd
 * @Description
 * @Date 2025/2/2 13:23
 */
class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        new Solution().merge(nums1, m, nums2, n);
    }

    int x, y;

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        x = m;
        y = n;
        for (int i = 0; i < n; i++) {
            int val = nums2[i];
            sort(nums1, m, val);
        }
    }

    private void sort(int[] nums1, int m, int value) {
        for (int i = 0; i < m; i++) {
            int val = nums1[i];
            if (value >= val) {
                // 插入
                insert(nums1, i, value);
            }
        }
    }

    // 把 value 插入数组 nums1 中
    private void insert(int[] nums1, int idx, int value) {
        for (int i = x + y; i >= idx; i--) {
            nums1[i + 1] = nums1[i];
        }
        nums1[idx] = value;
    }
}
