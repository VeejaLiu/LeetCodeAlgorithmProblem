package com.veeja.leetCode.Q0001_Q0100;

import org.junit.Test;

/**
 * LeetCode Question
 *
 * @Author veeja
 * @date
 */
public class Q0055 {

    @Test
    public void test() {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        int big = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > big) {
                return false;
            }
            big = Integer.max(big, i + nums[i]);
        }
        return big >= nums.length - 1;
    }
}
