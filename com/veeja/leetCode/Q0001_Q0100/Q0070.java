package com.veeja.leetCode.Q0001_Q0100;

import org.junit.Test;

/**
 * LeetCode 70 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @Author veeja
 * @Date 2025年03月05日14:17:20
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

/**
 * markdown
 * <p>
 * 解题思路：
 * 1. 递归
 * 递归的思路很简单，就是每次可以走1步或者2步，所以走到第n阶的方法数就是走到第n-1阶和第n-2阶的方法数之和。
 * 递归的缺点就是会有很多重复计算，所以会超时。
 * <p>
 * 2. 动态规划
 * 动态规划的思路和递归一样，只是不用重复计算，将计算结果保存下来。
 * 用a0、a1、a2三个变量分别保存第n-2阶、第n-1阶、第n阶的方法数，然后循环计算即可。
 */
