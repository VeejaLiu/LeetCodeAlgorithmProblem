package com.veeja.leetCode.question;

import org.junit.Test;

/**
 * LeetCode Question 1137
 *
 * 泰波那契序列Tn定义如下：
 *
 * T0 = 0, T1 = 1, T2 = 1,
 * 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 *
 * @Author veeja
 * @date
 */
public class Q1137 {

    @Test
    public void test() {
        System.out.println(tribonacci(1));
    }

    public int tribonacci(int n) {
        int result = 0;
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        if (n == 1 || n == 2) {
            return 1;
        }
        for (int i = 3; i <= n; i++) {
            result = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = result;
        }
        return result;
    }
}
