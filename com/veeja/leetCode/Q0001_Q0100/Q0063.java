package com.veeja.leetCode.Q0001_Q0100;

import org.junit.Test;

import java.util.Arrays;

/**
 * 0063. 不同路径 II
 * <p>
 * 给定一个 m x n 的整数数组 grid。
 * 一个机器人初始位于 左上角（即 grid[0][0]）。
 * 机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。机器人每次只能向下或者向右移动一步。
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
 * 返回机器人能够到达右下角的不同路径数量。
 * 测试用例保证答案小于等于 2 * 10^9。
 */
public class Q0063 {

    @Test
    public void test() {
        // 0 0 0
        // 0 1 0
        // 0 0 0
        int[][] grid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(grid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] path = new int[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (obstacleGrid[x][y] == 1) {
                    path[x][y] = 0;
                    continue;
                }
                if (x == 0 && y == 0) {
                    path[x][y] = 1;
                } else if (x == 0) {
                    path[x][y] = obstacleGrid[x][y - 1] == 1 ? 0 : path[x][y - 1];
                } else if (y == 0) {
                    path[x][y] = obstacleGrid[x - 1][y] == 1 ? 0 : path[x - 1][y];
                } else {
                    path[x][y] = (obstacleGrid[x - 1][y] == 1 ? 0 : path[x - 1][y]) + (obstacleGrid[x][y - 1] == 1 ? 0 : path[x][y - 1]);
                }
            }
        }

//        for (int i = 0; i < path.length; i++) {
//            System.out.println(Arrays.toString(path[i]));
//        }
        return path[m - 1][n - 1];

    }
}
