package com.veeja.leetCode.Q0801_Q0900;

import java.util.*;

/**
 * 有一个有 n 个节点的有向图，节点按 0 到 n - 1 编号。
 * 图由一个 索引从 0 开始 的 2D 整数数组 graph表示，
 * graph[i]是与节点 i 相邻的节点的整数数组，这意味着从节点 i 到 graph[i]中的每个节点都有一条边。
 * <p>
 * 如果一个节点没有连出的有向边，则该节点是 终端节点 。
 * 如果从该节点开始的所有可能路径都通向 终端节点 ，则该节点为 安全节点 。
 * <p>
 * 返回一个由图中所有 安全节点 组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 * <p>
 * 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * 输出：[2,4,5,6]
 * 解释：示意图如上。
 * 节点 5 和节点 6 是终端节点，因为它们都没有出边。
 * 从节点 2、4、5 和 6 开始的所有路径都指向节点 5 或 6 。
 * <p>
 * 输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * 输出：[4]
 * 解释:
 * 只有节点 4 是终端节点，从节点 4 开始的所有路径都通向节点 4 。
 */
public class Q0802 {
    public boolean safe(int[][] graph, int[] color, int i) {
        if (color[i] > 0) {
            // 如果该节点已经被访问过，直接返回该节点是否为安全节点
            return color[i] == 2;
        }

        // 如果该节点没有被访问过，将其标记为灰色
        color[i] = 1;

        // 从 i 节点出发，遍历其所有的邻接节点
        int[] g = graph[i];
        for (int j = 0; j < g.length; j++) {
            if (!safe(graph, color, g[j])) {
                return false;
            }
        }
        color[i] = 2;
        return true;
    }


    public List<Integer> eventualSafeNodes(int[][] graph) {

        // 颜色表示：
        // 0 白色，未访问，
        // 1 灰色，或者在栈内，表示正在访问
        // 2 安全节点，随着深度搜索，一直没有遇到灰色节点，说明是安全节点

        int[] color = new int[graph.length];
        List<Integer> result = new ArrayList<Integer>();

        // 首先判断 终端节点：
        // 1. 一个节点没有连出的有向边，则该节点是 终端节点
        for (int i = 0; i < graph.length; i++) {
            boolean isSafe = safe(graph, color, i);
            if (isSafe) {
                result.add(i);
            }
        }
        return result;
    }
}

/*

 */