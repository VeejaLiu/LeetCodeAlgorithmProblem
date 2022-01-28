package com.veeja.leetCode.Q0101Q0200;

import org.junit.Test;

import java.util.HashMap;

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

    static final char WATER = '0';
    static final char LAND = '1';

    /**
     * x[i]和y[i]代表结点的移动方向；
     * i = 0时，x-1, y不变，代表向左移动
     * i = 1时，x+1, y不变，代表向右移动
     * i = 2时，x不变, y+1，代表向下移动
     * i = 3时，x不变, y-1，代表向上移动
     */
    final int[] x = new int[]{-1, 1, 0, 0};
    final int[] y = new int[]{0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == WATER) {
                    continue;
                }
                // 如果找到一个陆地方块，就令结果+1，并将所有的邻接陆地修改为水。
                result++;
                dfsSearch(grid, i, j);
            }
        }
        return result;
    }

    public void dfsSearch(char[][] grid, int i, int j) {

        grid[i][j] = WATER;

//        printArrays(grid);

        for (int k = 0; k < 4; k++) {
            if (j + x[k] >= 0 && j + x[k] <= grid[i].length - 1 && i + y[k] >= 0 && i + y[k] <= grid.length - 1) {
                if (grid[i + y[k]][j + x[k]] == LAND) {
                    dfsSearch(grid, i + y[k], j + x[k]);
                }
            }
        }
        /*
        将下面的四种情况合起来写，就是上面的稍微复杂点的样子
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
        */
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
