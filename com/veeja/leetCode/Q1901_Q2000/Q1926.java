package com.veeja.leetCode.Q1901_Q2000;

import org.junit.Test;

/**
 * 1926. 迷宫中离入口最近的出口
 * 给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），
 * 矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。
 * 同时给你迷宫的入口 entrance ，用 entrance = [entrancerow, entrancecol]
 * 表示你一开始所在格子的行和列。
 * 每一步操作，你可以往 上，下，左 或者 右 移动一个格子。
 * 你不能进入墙所在的格子，你也不能离开迷宫。
 * 你的目标是找到离 entrance 最近 的出口。
 * 出口 的含义是 maze 边界 上的 空格子。
 * entrance 格子 不算 出口。*
 * 请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。
 */
public class Q1926 {

    @Test
    public void test() {
        // 输入：maze = [
        //               [++.+],
        //               [...+],
        //               [+++.]
        //             ],
        //      entrance = [1,2]
        // 输出：1
        // 解释：总共有 3 个出口，分别位于 (1,0)，(0,2) 和 (2,3) 。
        // 一开始，你在入口格子 (1,2) 处。
        // - 你可以往左移动 2 步到达 (1,0) 。
        // - 你可以往上移动 1 步到达 (0,2) 。
        // 从入口处没法到达 (2,3) 。
        // 所以，最近的出口是 (0,2) ，距离为 1 步。
        char[][] maze = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        int[] entrance = {1, 2};
        System.out.println(nearestExit(maze, entrance));
    }


    public int nearestExit(char[][] maze, int[] entrance) {

        return 0;
    }
}
