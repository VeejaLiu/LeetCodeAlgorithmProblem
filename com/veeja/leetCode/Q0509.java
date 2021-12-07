package com.veeja.leetCode;

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

        System.out.println("0:" + fib(0));
        System.out.println("1:" + fib(1));
        System.out.println("2:" + fib(2));
        System.out.println("3:" + fib(3));
        System.out.println("4:" + fib(4));
        System.out.println("5:" + fib(5));
        System.out.println("6:" + fib(6));
        System.out.println("7:" + fib(7));
        System.out.println("8:" + fib(8));
        System.out.println("9:" + fib(9));
        System.out.println("10:" + fib(10));
        System.out.println("11:" + fib(11));
        System.out.println("12:" + fib(12));
        System.out.println("13:" + fib(13));
        System.out.println("14:" + fib(14));
        System.out.println("15:" + fib(15));
        System.out.println("16:" + fib(16));
        System.out.println("17:" + fib(17));
        System.out.println("18:" + fib(18));
        System.out.println("19:" + fib(19));
        System.out.println("20:" + fib(20));
        System.out.println("21:" + fib(21));
        System.out.println("22:" + fib(22));
        System.out.println("23:" + fib(23));
        System.out.println("24:" + fib(24));
        System.out.println("25:" + fib(25));
        System.out.println("26:" + fib(26));
        System.out.println("27:" + fib(27));
        System.out.println("28:" + fib(28));
        System.out.println("29:" + fib(29));
        System.out.println("30:" + fib(30));
    }

    public int fib(int n) {
        int result = 0, fib0 = 0, fib1 = 1;
        if (n == 1) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            result = fib0 + fib1;
            fib0 = fib1;
            fib1 = result;
        }
        return result;
    }

}
