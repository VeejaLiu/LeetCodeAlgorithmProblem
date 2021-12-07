package com.veeja.jianzhioffer;

import org.junit.Test;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 *
 * @Author veeja
 * 2021/3/8 11:16
 */
public class Q0010_01 {
    @Test
    public void test() {

        System.out.println(fib(2));

    }

    public int fib(int n) {
        int result = 0, fib0 = 0, fib1 = 1;
        if (n == 1) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            result = (fib0 + fib1) % 1000000007;
            fib0 = fib1;
            fib1 = result;
            System.out.println(result);
        }
        return result;
    }
}
