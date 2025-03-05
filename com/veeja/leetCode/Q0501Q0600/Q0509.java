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
 * @Date 2025-03-05 14:27:39
 */
public class Q0509 {

    @Test
    public void test() {
        for (int xhnm = 0; xhnm < 31; xhnm++) {
            System.out.println("if(n==" + xhnm + "){return " + fib(xhnm) + ";}");
        }
    }

    /**
     * @param n 参数 n
     * @return 返回斐波那契数列的第n个数
     */
    public int fib(int n) {
        int f0 = 0, f1 = 1, fn = 0;
        if (n == 1) {
            return 1;
        }
        // 循环nm
        for (int i = 2; i <= n; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }
}
