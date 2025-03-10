package com.veeja.leetCode.Q0501_Q0600;

import org.junit.Test;

/**
 * 547. 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 * <p>
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * <p>
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 */
public class Q0547 {

    @Test
    public void test() {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(isConnected));
    }


    public void bfs(int[][] isConnected, int startPoint, int[] isVisited) {
        for (int i = 0; i < isConnected.length; i++) {
            if (i == startPoint) {
                continue;
            }
            if (isVisited[i] == 1) {
                continue;
            }
            if (isConnected[startPoint][i] == 1) {
                isVisited[i] = 1;
                bfs(isConnected, i, isVisited);
            }
        }
    }


    public int findCircleNum(int[][] isConnected) {
        int cityNumber = isConnected.length;
        int[] isVisited = new int[cityNumber];
        int count = 0;

        for (int i = 0; i < cityNumber; i++) {
            if (isVisited[i] == 1) {
                continue;
            }
            // 对 i 进行搜索
            bfs(isConnected, i, isVisited);
            count++;
        }
        return count;
    }
}

/*
图论题目

首先是
1 1 0
1 1 0
0 0 1

A  C
|
B

最笨比的办法，遍历一遍，建立一个二维数组，如果有相连的，把它们加入一个数组，最后看看得到几个分类


搜索算法，一个一个搜索，搜到了一个就把它的所有相连的都搜一遍，搜过的标记一下，最后看看有几个分类
 */