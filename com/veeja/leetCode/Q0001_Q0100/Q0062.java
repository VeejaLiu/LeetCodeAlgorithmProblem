package com.veeja.leetCode.Q0001_Q0100;

import org.junit.Test;


/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class Q0062 {


    @Test
    public void test() {
        System.out.println(uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        int[][] path = new int[m + 1][n + 1];
        for (int x = 1; x <= m; x++) {
            for (int y = 1; y <= n; y++) {
                if (x == 1 && y == 1) {
                    path[x][y] = 1;
                } else if (x == 1) {
                    path[x][y] = path[x][y - 1];
                } else if (y == 1) {
                    path[x][y] = path[x - 1][y];
                } else {
                    path[x][y] = path[x - 1][y] + path[x][y - 1];
                }
            }
        }
//        for (int i = 0; i < path.length; i++) {
//            System.out.println(Arrays.toString(path[i]));
//        }
        return path[m][n];
    }
}


/*

对于 m * n 的网络,

例如: 3 * 7 的网络
    | 1 | 2 | 3 | 4 | 5 | 6 | 7 | n/y
  1 | S |   |   |   |   |   |   |
  2 |   |   |   |   |   |   |   |
  3 |   |   |   |   |   |   | F |
 m/x

我们定义为path(x, y)为到达 (x, y) 的路径数量
那么一般情况下，
想到达 (x, y)，要么从 (x-1, y) 向下走一步，要么从 (x, y-1) 向右走一步
也就是 path(x, y) = path(x-1, y) + path(x, y-1)

对于边界情况，
- 当 y = 1 时， path(x, y) = path(x-1, y), 只能从上面走下来
- 当 x = 1 时， path(x, y) = path(x, y-1), 只能从左边走过来
 */
