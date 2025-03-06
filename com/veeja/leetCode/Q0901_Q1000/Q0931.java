package com.veeja.leetCode.Q0901_Q1000;

import com.veeja.leetCode.util.ArrayUtil;
import org.junit.Test;

/**
 * 给你一个 n x n 的 方形 整数数组 matrix ，
 * 请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，
 * 并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 */
public class Q0931 {
    @Test
    public void test() {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(minFallingPathSum(matrix));

        // 输入：matrix = [[-19,57],[-40,-5]]
        int[][] matrix2 = {{-19, 57}, {-40, -5}};
        System.out.println(minFallingPathSum(matrix2));
    }


    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

//        ArrayUtil.printArray(matrix);

        int dp[][] = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (j == 0) {
                    // 每一行的第一个元素，只能从右上方或者正上方到达
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == n - 1) {
                    // 每一行的最后一个元素，只能从左上方或者正上方到达
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                } else {
                    // 其他情况
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
                }
            }
        }

//        ArrayUtil.printArray(dp);

        int minValue = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                minValue = dp[n - 1][i];
            } else {
                minValue = Math.min(minValue, dp[n - 1][i]);
            }
        }

        return minValue;
    }
}


/*
这个题和之前的矩阵DP都差不多，无非就是矩阵的转移方程的边界条件有所不同而已：
例如：
matrix = [[2,1,3],[6,5,4],[7,8,9]]

[
 [2,1,3],
 [6,5,4],
 [7,8,9]
]

对于矩阵中的每一个元素，我们都可以从上一行的三个元素中选择一个元素，然后加上当前元素的值，得到当前元素的最小路径和。
也就是说:
dp[i][j] = min(
  dp[i-1][j-1], // 左上
  dp[i-1][j],   // 正上
  dp[i-1][j+1]  // 右上
) + matrix[i][j]

然后讨论边界条件：
1. 第一行的最小路径和就是本身
2. 每一行的最后一个元素，只能从上方或者左上方到达
3. 每一行的第一个元素，只能从上方或者右上方到达

最后一行，开始遍历并且找到最小值
 */