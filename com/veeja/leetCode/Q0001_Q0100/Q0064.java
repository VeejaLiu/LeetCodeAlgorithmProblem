package com.veeja.leetCode.Q0001_Q0100;

import org.junit.Test;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，
 * 请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
public class Q0064 {
    @Test
    public void test() {
        // 1 3 1
        // 1 5 1
        // 4 2 1
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }


    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] minValue = new int[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (x == 0 && y == 0) {
                    minValue[x][y] = grid[x][y];
                } else if (x == 0) {
                    minValue[x][y] = minValue[x][y - 1] + grid[x][y];
                } else if (y == 0) {
                    minValue[x][y] = minValue[x - 1][y] + grid[x][y];
                } else {
                    minValue[x][y] = Math.min(minValue[x - 1][y], minValue[x][y - 1]) + grid[x][y];
                }
            }
        }

//        for (int x = 0; x < m; x++) {
//            for (int y = 0; y < n; y++) {
//                System.out.print(minValue[x][y] + " ");
//            }
//            System.out.println();
//        }

        return minValue[m - 1][n - 1];
    }
}

/*
跟之前的题目 Q0062 类似，只是这次要求的是最小值
*/
