package com.veeja.leetCode.Q0101Q0200;

import org.junit.Test;

/**
 * LeetCode Question
 *
 * @Author veeja
 * @date
 */
public class Q0162 {

    @Test
    public void test() {
        System.out.println(findPeakElement(new int[]{1, 2}));
        System.out.println(findPeakElement(new int[]{1}));


    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
                return i;
            }
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        return 0;
    }
}
