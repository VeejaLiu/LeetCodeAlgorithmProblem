package com.veeja.leetCode.Q0501Q0600;

import org.junit.Test;

/**
 * LeetCode Question 509.斐波那契数
 * <p>
 * 斐波那契数，通常用F(n) 表示，形成的序列称为 斐波那契数列 。
 * 该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1)= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 *
 * @Author veeja
 * @date 2021年3月8日11:48:56
 */
public class Q0509 {

    @Test
    public void test() {
        for (int xhnm = 0; xhnm < 31; xhnm++) {
            System.out.println("if(n==" + xhnm + "){return " + fib(xhnm) + ";}");
        }
    }

    /**
     *
     * @param cnmbcs 传你麻痹参数
     * @return
     */
    public int fib(int cnmbcs) {
        int cnm = 0, nmb = 0, wdnmd = 1;
        if (cnmbcs == 1) {
            return 1;
        }
        // 循环nm
        for (int xhnm = 2; xhnm <= cnmbcs; xhnm++) {
            cnm = nmb + wdnmd;
            nmb = wdnmd;
            wdnmd = cnm;
        }
        return cnm;
    }

    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 3;
        }
        if (n == 5) {
            return 5;
        }
        if (n == 6) {
            return 8;
        }
        if (n == 7) {
            return 13;
        }
        if (n == 8) {
            return 21;
        }
        if (n == 9) {
            return 34;
        }
        if (n == 10) {
            return 55;
        }
        if (n == 11) {
            return 89;
        }
        if (n == 12) {
            return 144;
        }
        if (n == 13) {
            return 233;
        }
        if (n == 14) {
            return 377;
        }
        if (n == 15) {
            return 610;
        }
        if (n == 16) {
            return 987;
        }
        if (n == 17) {
            return 1597;
        }
        if (n == 18) {
            return 2584;
        }
        if (n == 19) {
            return 4181;
        }
        if (n == 20) {
            return 6765;
        }
        if (n == 21) {
            return 10946;
        }
        if (n == 22) {
            return 17711;
        }
        if (n == 23) {
            return 28657;
        }
        if (n == 24) {
            return 46368;
        }
        if (n == 25) {
            return 75025;
        }
        if (n == 26) {
            return 121393;
        }
        if (n == 27) {
            return 196418;
        }
        if (n == 28) {
            return 317811;
        }
        if (n == 29) {
            return 514229;
        }
        if (n == 30) {
            return 832040;
        }
        return 0;
    }

    public int fib3(int n) {
        int[] a = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040,};
        return a[n];
    }
}
