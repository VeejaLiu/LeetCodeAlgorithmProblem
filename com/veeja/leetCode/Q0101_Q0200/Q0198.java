package com.veeja.leetCode.Q0101_Q0200;

import org.junit.Test;

/**
 * LeetCode Question
 *
 * @Author veeja
 * @date
 */
public class Q0198 {

    @Test
    public void test() {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

    /**
     * 一个一个抢，在"抢劫当前"和"放弃当前"中做一个最优选。
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int[] results = new int[nums.length];
        int maxValue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                maxValue = nums[i];
                results[i] = maxValue;
            } else if (i == 1) {
                int initValue = 0;
                results[i] = Integer.max(nums[i] + initValue, results[i - 1]);
                maxValue = results[i];
            } else {
                results[i] = Integer.max(nums[i] + results[i - 2], results[i - 1]);
                maxValue = results[i];
            }
        }
        return maxValue;
    }
}
