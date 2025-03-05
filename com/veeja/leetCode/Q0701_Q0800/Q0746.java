package com.veeja.leetCode.Q0701_Q0800;

import org.junit.Test;

import java.util.Arrays;

/**
 * 0746. 使用最小花费爬楼梯
 * <p>
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
public class Q0746 {

    @Test
    public void test() {
//        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        System.out.println("Result = " + minCostClimbingStairs(cost));
//
//        int[] cost2 = {10, 15, 20};
//        System.out.println("Result = " + minCostClimbingStairs(cost2));
//
//        int[] cost3 = {1};
//        System.out.println("Result = " + minCostClimbingStairs(cost3));
//
//        int[] cost4 = {1, 1};
//        System.out.println("Result = " + minCostClimbingStairs(cost4));
//
//        int[] cost5 = {1, 2, 4};
//        System.out.println("Result = " + minCostClimbingStairs(cost5));
//
//        int[] cost6 = {0, 0, 1, 1};
//        System.out.println("Result = " + minCostClimbingStairs(cost6));

        int[] cost7 = {1, 100};
        System.out.println("Result = " + minCostClimbingStairs(cost7));
    }


    /**
     * @param cost 每层楼梯的花费
     *             1,  100,  1,  1,  1,  100,  1,  1,  100,  1
     *             0     1   2   3   4     5   6   7     8   9
     */
    public int minCostClimbingStairs(int[] cost) {
//        System.out.println("====================================================\n");

//        System.out.println("cost = " + Arrays.toString(cost));

//        System.out.println("cost.length = " + cost.length);
        if (cost.length == 1) {
            return cost[0];
        }
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int min0 = 0;
        int min1 = 0;
        int minN = 0;

        for (int i = 2; i < cost.length; i++) {
//            System.out.println("n = " + i);
//            System.out.println("min(n-1) = min(" + (i - 1) + ") = " + min1);
//            System.out.println("cost[n-1] = cost[" + (i - 1) + "] = " + cost[i - 1]);
//            System.out.println("min(n-2) = min(" + (i - 2) + ") = " + min0);
//            System.out.println("cost[n-2] = cost[" + (i - 2) + "] = " + cost[i - 2]);
            minN = Math.min(min1 + cost[i - 1], min0 + cost[i - 2]);
//            System.out.println("min(n) = min(" + i + ") = " + minN);

            min0 = min1;
            min1 = minN;
//            System.out.println();
        }
        return Math.min(min0 + cost[cost.length - 2], min1 + cost[cost.length - 1]);
    }
}

/*
跟之前的爬楼梯区别不大。
我们假定 爬到某层楼梯的最小花费为 min(n)
爬到第n层楼，无非就是两种方式：
1. 从第n-1层爬上来，花费为 min(n-1) + cost[n]
2. 从第n-2层爬上来，花费为 min(n-2) + cost[n]
所以，爬到第n层的最小花费就是 min(n) = min(min(n-1) + cost[n], min(n-2) + cost[n])

因为可以从0或者1开始，意味着
min(0) = 0
min(1) = 0
 */