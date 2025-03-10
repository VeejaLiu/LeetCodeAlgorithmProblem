package com.veeja.leetCode.Q0601_Q0700;

import com.veeja.leetCode.util.ArrayUtil;
import org.junit.Test;

/**
 * 673. 最长递增子序列的个数
 * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数。
 * 注意 这个数列必须是 严格 递增的。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * <p>
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 */
public class Q0673 {

    @Test
    public void test() {
//        int[] nums1 = {1, 3, 5, 4, 7};
//        System.out.println(findNumberOfLIS(nums1));

//        int[] nums2 = {2, 2, 2, 2, 2};
//        System.out.println(findNumberOfLIS(nums2));
//
        int[] nums3 = {1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println(findNumberOfLIS(nums3));

    }

    public int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        int maxValue = 0;

        int[] dp = new int[length];
        int[] counts = new int[length];

        for (int i = 0; i < length; i++) {

            int currentNumber = nums[i];
            System.out.println("i=" + i + ", current number = " + currentNumber + " --------");

            dp[i] = 1;
            counts[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < currentNumber) {
                    if (dp[j] + 1 >= dp[i]) {
                        dp[i] = dp[j] + 1;
                        counts[i] = counts[j];
                    } else if (dp[j] + 1 >= dp[i]) {
                        counts[i] = counts[j] + 1;
                    }
                }
            }
            if (dp[i] > maxValue) {
                maxValue = dp[i];
            }

            ArrayUtil.printArray(dp);

        }

        return maxValue;
    }
}

/*
尝试动态规划：

对于
     [1,    3,    5,    4,    7]

 */