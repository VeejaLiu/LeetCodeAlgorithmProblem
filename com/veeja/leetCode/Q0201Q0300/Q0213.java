package com.veeja.leetCode.Q0201Q0300;

import org.junit.Test;

/**
 * LeetCode Question
 *
 * @Author veeja
 * @date
 */
public class Q0213 {

    @Test
    public void test() {
        System.out.println(rob(new int[]{2, 3, 2}));
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{1, 2, 3}));
        System.out.println(rob(new int[]{5, 1, 2, 3}));
    }

    /**
     * 循环打家劫舍，抢首不抢尾，抢尾不抢首，分情况讨论即可。循环两遍。
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        int[] results = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Integer.max(nums[1], nums[0]);
        }

        int maxValue = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0) {
                maxValue = nums[i];
                results[i] = maxValue;
            } else if (i == 1) {
                results[i] = Integer.max(nums[i], results[i - 1]);
                maxValue = results[i];
            } else {
                results[i] = Integer.max(nums[i] + results[i - 2], results[i - 1]);
                maxValue = results[i];
            }
        }
        int maxValue2 = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (i == nums.length - 1) {
                maxValue2 = nums[i];
                results[i] = maxValue2;
            } else if (i == nums.length - 2) {
                results[i] = Integer.max(nums[i], results[i + 1]);
                maxValue2 = results[i];
            } else {
                results[i] = Integer.max(nums[i] + results[i + 2], results[i + 1]);
                maxValue2 = results[i];
            }
        }
        return Integer.max(maxValue, maxValue2);
    }
}
