package com.veeja.leetCode.Q0601Q0700;

import org.junit.Test;

/**
 * LeetCode Question
 *
 * @Author veeja
 * @date
 */
public class Q0650 {

    @Test
    public void test() {
        // for (int i = 0; i < 100; i++) {
        //     System.out.println(i + ", result = " + minSteps(i));
        // }
        System.out.println(minSteps(18));
    }

    /**
     * 只有两个键的键盘
     * MDZZ!
     * > 2022/01/28 18:31:51
     * Success:
     * Runtime:28 ms, faster than 22.53% of Java online submissions.
     * Memory Usage:38.5 MB, less than 9.60% of Java online submissions.
     *
     * @param n
     * @return
     */
    public int minSteps(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = i;
            if (i == 1) {
                int initValue = 0;
                result[i] = Integer.min(initValue, result[i]);
            }
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    result[i] = Integer.min(result[i], result[j] + (i / j));
                }
            }
        }
        return result[n];
    }
}
