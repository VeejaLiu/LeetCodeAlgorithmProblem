package com.veeja.leetCode.question;

import org.junit.Test;

/**
 * LeetCode Question 1281
 *
 * 给你一个整数n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 *
 * 示例 1：
 *
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * 示例 2：
 *
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 *
 * 提示：
 * 1 <= n <= 10^5
 *
 * @Author veeja
 * @date
 */
public class Q1281 {

    @Test
    public void test() {
        System.out.println(subtractProductAndSum(4421));
    }

    public int subtractProductAndSum(int n) {

        int ji = 1;
        int he = 0;
        while (true) {
            // 取最后一位数
            int number = n % 10;
            n = n / 10;
            ji *= number;
            he += number;
            if (n == 0) {
                break;
            }
        }
        return ji - he;
    }
}
