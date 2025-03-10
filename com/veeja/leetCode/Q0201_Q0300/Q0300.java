package com.veeja.leetCode.Q0201_Q0300;

import org.junit.Test;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 */
public class Q0300 {

    @Test
    public void test() {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
//        System.out.println(lengthOfLIS(nums));

        int[] nums2 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lengthOfLIS(nums2));
    }


    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int maxValue = 0;

        int[] dp = new int[length];

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                dp[i] = 1;
                maxValue = 1;
                continue;
            }

            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] + 1 >= max && nums[j] < nums[i]) {
                    max = dp[j] + 1;
                }
            }
            dp[i] = max;
            if (max > maxValue) {
                maxValue = max;
            }
//            ArrayUtil.printArray(dp);
        }


        return maxValue;
    }
}

/*
尝试动态规划：
  dp[i] 到 i 为止，目前数组的最长递增子序列。

10    1
9     1
2     1
5     2
3     2
7     3
101   4
18    4
 */