package com.veeja.leetCode.Q1101_Q1200;

/**
 * TODO uncompleted
 *
 * 1129. 颜色交替的最短路径
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个整数 n，即有向图中的节点数，其中节点标记为 0 到 n - 1。图中的每条边为红色或者蓝色，并且可能存在自环或平行边。
 * 给定两个数组 redEdges 和 blueEdges，其中：
 * redEdges[i] = [ai, bi] 表示图中存在一条从节点 ai 到节点 bi 的红色有向边，
 * blueEdges[j] = [uj, vj] 表示图中存在一条从节点 uj 到节点 vj 的蓝色有向边。
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
 */
public class Q1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        for (int i = 0; i < n; i++) {

        }
    }
}


/*
输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
输出：[0,1,-1]

输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
输出：[0,1,-1]
 */