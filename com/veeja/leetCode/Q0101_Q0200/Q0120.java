package com.veeja.leetCode.Q0101_Q0200;

import com.veeja.leetCode.util.ArrayUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 示例 2：
 * 输入：triangle = [[-10]]
 * 输出：-10
 */
public class Q0120 {

    @Test
    public void test() {
        // [[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> triangle = List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3));
        System.out.println(minimumTotal(triangle));
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        System.out.println(n);

        // print triangle
        for (List<Integer> list : triangle) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        int minValue = 0;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > i) {
                    // 0. 如果 j > i, 说明这个位置是不存在的，直接跳过
                    break;
                } else if (i == 0 && j == 0) {
                    // 1. 第一行的最小路径和就是本身
                    dp[i][j] = triangle.get(i).get(j);
                } else if (j == i) {
                    // 2. 每一行的最后一个元素，只能从上一行的最后一个元素到达
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else if (j == 0) {
                    // 3. 每一行的第一个元素，只能从上一行的第一个元素到达
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else {
                    // 3. 其他情况
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }

                // 最后一行，开始遍历并且找到最小值
                if (i == n - 1) {
                    if (j == 0) {
                        minValue = dp[i][j];
                    } else {
                        minValue = Math.min(minValue, dp[i][j]);
                    }
                }
            }
        }
        System.out.println("dp:");
        ArrayUtil.printArray(dp);

        return minValue;
    }
}


/*
[
   [2],
  [3,4],
 [6,5,7],
[4,1,8,3]
]

如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
那就意味着如果想到达 i，必须从上一行的 i - 1 或者 i 到达
所以某个位置的最小路径和，只与上一行的两个位置有关，
所以可以得到状态转移方程：
dp[i][j] = min( dp[i-1][j-1], dp[i][j-1] ) + triangle[i][j]

然后讨论边界条件：
0. 如果 j > i, 说明这个位置是不存在的，直接跳过
1. 第一行的最小路径和就是本身，也就是如果i=0, j=0, dp[i][j] = triangle[i][j]
2. 每一行的最后一个元素，只能从上一行的最后一个元素到达，也就是如果i=j, dp[i][j] = dp[i-1][j-1] + triangle[i][j]
3. 每一行的第一个元素，只能从上一行的第一个元素到达，也就是如果j=0, dp[i][j] = dp[i-1][j] + triangle[i][j]
 */