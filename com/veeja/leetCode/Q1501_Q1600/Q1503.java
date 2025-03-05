package com.veeja.leetCode.Q1501_Q1600;

import org.junit.Test;

import java.util.Arrays;

/**
 * 《挑战程序设计竞赛》第2版 题 1.6.2
 * LeetCode Question 1503
 *
 * @Author veeja
 * @date 2021年3月8日10:22:31
 */
public class Q1503 {

    @Test
    public void test() {

        int n = 7;
        int[] left = {};
        int[] right = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(getLastMoment(n, left, right));
        System.out.println(getLastMoment2(n, left, right));

    }

    public int getLastMoment(int n, int[] left, int[] right) {

        Arrays.sort(left);
        Arrays.sort(right);
        if (right.length == 0) {
            return left[left.length - 1];
        }
        if (left.length == 0) {
            return n - right[0];
        }
        if (left.length == 0 && right.length == 0) {
            return 0;
        }
        return Integer.max(left[left.length - 1], n - right[0]);
    }

    public int getLastMoment2(int n, int[] left, int[] right) {

        int result = 0;

        for (int j : left) {
            result = Math.max(result, j);
        }
        for (int j : right) {
            result = Math.max(result, (n - j));
        }
        return result;
    }
}
