package com.veeja.leetCode.Q0101_Q0200;

import org.junit.Test;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你不触动警报装置的情况下，一夜之内能够偷窃到的最高金额。
 */
public class Q0198 {

    @Test
    public void test() {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

    /**
     * @param nums 房屋金额数组
     */
    public int rob(int[] nums) {
        int max[] = new int[nums.length];
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                max[i] = nums[i];
            } else if (i == 1) {
                max[i] = Math.max(nums[i], nums[i - 1]);
            } else {
                max[i] = Math.max(max[i - 1], max[i - 2] + nums[i]);
            }
        }
        return max[nums.length - 1];
    }
}

/*
从头抢到尾:
第一个房间，只能抢第一个房间
max[0] = nums[0]
第二个房间，抢第一个房间和第二个房间中金额较多的那个
max[1] = max(nums[0], nums[1])
从第三个房间开始，如果房间号为n，
就需要从以下方案中选择一种：
- 抢劫n, 放弃n-1, 这个时候的金额为 max[n-2] + nums[n]
- 不抢劫n, 这个时候的金额为 max[n-1]
因此状态转移方程为 max[n] = max(max[n-2] + nums[n], max[n-1])
 */