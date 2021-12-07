package com.veeja.leetCode.question;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * 《挑战程序设计竞赛》第2版 题1.6.1
 * LeetCode Question 976
 *
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * 示例 1：
 * 输入：[2,1,2]
 * 输出：5
 * 示例 2：
 * 输入：[1,2,1]
 * 输出：0
 * 示例 3：
 * 输入：[3,2,3,4]
 * 输出：10
 * 示例 4：
 * 输入：[3,6,2,3]
 * 输出：8
 * 提示：
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 *
 * @Author veeja
 * 2021/3/7 22:15
 */
public class Q0976 {
    @Test
    public void test() {
        int[] nums = {2, 1, 2};
        System.out.println(largestPerimeter(nums));
        int[] nums2 = new int[]{1, 2, 1};
        System.out.println(largestPerimeter(nums2));
        int[] nums3 = new int[]{3, 2, 3, 4};
        System.out.println(largestPerimeter(nums3));
        int[] nums4 = new int[]{3, 6, 2, 3};
        System.out.println(largestPerimeter(nums4));
    }

    public int largestPerimeter(int[] nums) {
//        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }
        return 0;
    }
}
