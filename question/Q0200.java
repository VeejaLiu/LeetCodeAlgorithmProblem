package com.veeja.leetCode.question;

import org.junit.Test;

import java.util.Arrays;

/**
 * 200. 岛屿数量
 *
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * 输入：grid = {
 * {'1','1','1','1','0'},
 * {'1','1','0','1','0'},
 * {'1','1','0','0','0'},
 * {'0','0','0','1','0']
 * }
 * 输出：1
 *
 * @Author veeja
 * @date 2021年3月8日14:25:13
 * @Tags 搜索
 */
public class Q0200 {

    @Test
    public void test() {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid));

        char[][] grid2 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid2));
    }

    final char WATER = '0';
    final char LAND = '1';

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == WATER) {
                    continue;
                }
                result++;
                dfsSearch(grid, i, j);
            }
        }
        return result;
    }

    public void dfsSearch(char[][] grid, int i, int j) {

        grid[i][j] = WATER;

        printArrays(grid);
        // 向左搜索
        if (j - 1 >= 0) {
            if (grid[i][j - 1] == LAND) {
                dfsSearch(grid, i, j - 1);
            }
        }
        // 向上搜索
        if (i - 1 >= 0) {
            if (grid[i - 1][j] == LAND) {
                dfsSearch(grid, i - 1, j);
            }
        }
        // 向右搜索
        if (j + 1 <= grid[i].length - 1) {
            if (grid[i][j + 1] == LAND) {
                dfsSearch(grid, i, j + 1);
            }
        }
        // 向下搜索
        if (i + 1 <= grid.length - 1) {
            if (grid[i + 1][j] == LAND) {
                dfsSearch(grid, i + 1, j);
            }
        }
    }

    public void printArrays(char[][] grid) {
        System.out.println("------------------");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------");
    }

}
