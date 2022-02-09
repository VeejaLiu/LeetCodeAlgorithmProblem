package com.veeja.leetCode.Q0401Q0500;

import org.junit.Test;

/**
 * LeetCode Question
 *
 * @Author veeja
 * @date
 */
public class Q0495 {


    @Test
    public void test() {
        System.out.println(findPoisonedDuration(new int[]{1, 2}, 2));
        System.out.println(findPoisonedDuration(new int[]{1, 4}, 2));
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = timeSeries.length * duration;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i + 1] - timeSeries[i] < duration) {
                result -= (duration - (timeSeries[i + 1] - timeSeries[i]));
            }
        }
        return result;
    }
}
