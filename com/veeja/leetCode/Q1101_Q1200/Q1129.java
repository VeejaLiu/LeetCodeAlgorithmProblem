package com.veeja.leetCode.Q1101_Q1200;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO uncompleted
 * <p>
 * 1129. 颜色交替的最短路径
 * 给定一个整数 n，即有向图中的节点数，其中节点标记为 0 到 n - 1。图中的每条边为红色或者蓝色，并且可能存在自环或平行边。
 * 给定两个数组 redEdges 和 blueEdges，其中：
 * redEdges[i] = [ai, bi] 表示图中存在一条从节点 ai 到节点 bi 的红色有向边，
 * blueEdges[j] = [uj, vj] 表示图中存在一条从节点 uj 到节点 vj 的蓝色有向边。
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
 */
public class Q1129 {

    @Test
    public void test() {
        //        // 输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
        //        // 输出：[0,1,-1]
        //        int n = 3;
        //        int[][] redEdges = {{0, 1}, {2, 1}};
        //        int[][] blueEdges = {};
        //        int res = shortestAlternatingPaths(n, redEdges, blueEdges);
        //        System.out.println(res);

        simpleShortPath();
    }

    public void simpleShortPath() {
        //       0 -- 1
        //       |    | \
        //       |    |  \
        //       2 -- 3 -- 4
        //               /
        //              /
        //       5 -- 6
        int[][] graph = {
                {1, 2}, // 0
                {0, 3, 4}, // 1
                {0, 3}, // 2
                {1, 2, 4}, // 3
                {1, 3, 6}, // 4
                {6}, // 5
                {4, 5}, // 6
        };
        int result = bfs(0, 5, graph);
        System.out.println(result);
    }

    private int bfs(int start, int end, int[][] graph) {
        // 创建一个队列
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        // 创建一个数组，记录是否访问过
        int[] visited = new int[graph.length];
        visited[start] = 1;

        // 存储当前节点的深度
        int[] distance = new int[graph.length];

        while (!queue.isEmpty()) {
            int head = queue.poll();
            System.out.println("head: " + head);

            // 遍历所有的邻接节点
            for (int neighbor : graph[head]) {
                if (visited[neighbor] != 1) {
                    visited[neighbor] = 1;
                    queue.offer(neighbor);
                    distance[neighbor] = distance[head] + 1;

                    // 如果到达目标节点，返回路径长度
                    if (neighbor == end) {
                        return distance[neighbor];
                    }
                }
            }
        }

        return -1;
    }


    public int shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // 计算从0到n-1的最短路径
        int res = shortPath(0, n - 1, redEdges, blueEdges, 0, 0);
        return res;
    }

    private int shortPath(int start, int end, int[][] redEdges, int[][] blueEdges, int lastColor, int depth) {
        /*
         * last color:
         *  0 - No color
         *  1 - Red
         *  2 - Blue
         */
        depth++;
        switch (lastColor) {
            // Red，所以我们需要找蓝色的图
            case 1:
                for (int i = 0; i < blueEdges[start].length; i++) {
                    if (blueEdges[start][i] == end) {
                        return depth;
                    } else {
                        depth += shortPath(blueEdges[start][i], end, redEdges, blueEdges, 2, depth);
                    }
                }
                break;
            // Blue，所以我们需要找红色的图
            case 2:
                for (int i = 0; i < redEdges[start].length; i++) {
                    if (redEdges[start][i] == end) {
                        return depth;
                    } else {
                        depth += shortPath(redEdges[start][i], end, redEdges, blueEdges, 1, depth);
                    }
                }
                break;
            default:
                int redFirstDepth = depth;
                for (int i = 0; i < redEdges[start].length; i++) {
                    if (redEdges[start][i] == end) {

                    } else {
                        redFirstDepth += shortPath(redEdges[start][i], end, redEdges, blueEdges, 1, depth);
                    }
                }
                int blueFirstDepth = depth;
                for (int i = 0; i < blueEdges[start].length; i++) {
                    if (blueEdges[start][i] == end) {
                    } else {
                        blueFirstDepth += shortPath(blueEdges[start][i], end, redEdges, blueEdges, 2, depth);
                    }
                }
                depth = Math.min(redFirstDepth, blueFirstDepth);
        }
        return depth;
    }
}


/*
输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
输出：[0,1,-1]

输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
输出：[0,1,-1]


假设从 0 出发到 n-1：


 */