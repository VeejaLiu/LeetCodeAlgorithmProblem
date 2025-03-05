package com.veeja.leetCode.Q0401_Q0500;

import org.junit.Test;

/**
 * LeetCode Question
 *
 * @Author veeja
 * @date
 */
public class Q0485 {

    @Test
    public void test() {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));

    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int temResult = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temResult++;
            } else {
                temResult = 0;
            }
            result = Math.max(result, temResult);
        }
        return result;
    }

}
