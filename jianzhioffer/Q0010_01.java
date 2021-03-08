package com.veeja.leetCode.jianzhioffer;

import org.junit.Test;

/**
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
        if (n == 1 || n == 2) {
            return 1;
        }
        for (int i = 3; i <= n; i++) {
            result = (fib0 + fib1) % 1000000007;
            fib0 = fib1;
            fib1 = result;
            System.out.println(result);
        }
        return fib0;
    }
}
