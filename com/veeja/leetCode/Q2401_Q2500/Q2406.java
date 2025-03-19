package com.veeja.leetCode.Q2401_Q2500;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Unfinished
 *
 * 2406. 将区间分为最少组数
 * 给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti] 表示 闭 区间 [lefti, righti] 。
 * 你需要将 intervals 划分为一个或者多个区间 组 ，每个区间 只 属于一个组，且同一个组中任意两个区间 不相交 。
 * 请你返回 最少 需要划分成多少个组。
 * 如果两个区间覆盖的范围有重叠（即至少有一个公共数字），那么我们称这两个区间是 相交 的。比方说区间 [1, 5] 和 [5, 8] 相交。
 * <p>
 * 示例 1：
 * 输入：intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
 * 输出：3
 * 解释：我们可以将区间划分为如下的区间组：
 * - 第 1 组：[1, 5] ，[6, 8] 。
 * - 第 2 组：[2, 3] ，[5, 10] 。
 * - 第 3 组：[1, 10] 。
 * 可以证明无法将区间划分为少于 3 个组。
 * <p>
 * 示例 2：
 * 输入：intervals = [[1,3],[5,6],[8,10],[11,13]]
 * 输出：1
 * 解释：所有区间互不相交，所以我们可以把它们全部放在一个组内。
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 105
 * intervals[i].length == 2
 * 1 <= lefti <= righti <= 106
 */
public class Q2406 {

    @Test
    public void test() {
        int[][] intervals = {{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}};
        System.out.println(minGroups(intervals));
    }

    @Test
    public void test2() {
        int[][] intervals = {{1, 3}, {5, 6}, {8, 10}, {11, 13}};
        System.out.println(minGroups(intervals));
    }


    public int minGroups(int[][] intervals) {

        // create a new map, key is the number, value is the count of the number
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            for (int j = interval[0]; j <= interval[1]; j++) {
                // System.out.println(j);
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }

        // System.out.println(map);

        // find the max count
        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        return max;
    }
}

/*
直觉告诉我，直接找到重复的区间就可以了。

我来个粗暴的解法：
将每个数字都统计一遍，看看最多的数字出现了几次。

不出意外的是，正确，但是超时了。

琢磨琢磨怎么优化一下。
 */