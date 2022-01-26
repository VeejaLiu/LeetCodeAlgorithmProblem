package com.veeja.leetCode;

import org.junit.Test;

/**
 * LeetCode Question
 *
 * @Author veeja
 * @date
 */
public class Q0070 {

    @Test
    public void test() {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
    }

    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            int a0 = 1;
            int a1 = 1;
            int a2 = 0;
            for (int i = 2; i <= n; i++) {
                a2 = a1 + a0;
                a0 = a1;
                a1 = a2;
            }
            return a2;
        }
    }
}
