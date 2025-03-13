package com.veeja.leetCode.Q1401_Q1500;

import org.junit.Test;

import java.util.*;

/**
 * 1466. 重新规划路线
 * <p>
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。
 * 因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。
 * 去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 */
public class Q1466 {



/*
示例 1：
输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
输出：3
解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。

示例 2：
输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
输出：2
解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。

示例 3：
输入：n = 3, connections = [[1,0],[2,0]]
输出：0
 */


    @Test
    public void test() {
        /*
                     3  <-- 2
                   ↗
                 1
              ↗
            0 <-- 4 <-- 5
         */
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        // output: 3
        System.out.println(minReorder(n, connections));
    }

    @Test
    public void test2() {
        int n = 5;
        int[][] connections = {{1, 0}, {1, 2}, {3, 2}, {3, 4}};
        // output: 2
        System.out.println(minReorder(n, connections));
    }

    @Test
    public void test3() {
        int n = 3;
        int[][] connections = {{1, 0}, {2, 0}};
        // output: 0
        System.out.println(minReorder(n, connections));
    }

    public int minReorder(int n, int[][] connections) {
        // 从某城市 可以 到达 哪些城市
        Map<Integer, ArrayList<Integer>> reachToMap = new HashMap<>();
        // 从 哪些城市 可以 到达 该城市
        Map<Integer, ArrayList<Integer>> reachHereMap = new HashMap<>();

        for (int[] connection : connections) {
            int startCity = connection[0];
            int endCity = connection[1];
            if (!reachToMap.containsKey(startCity)) {
                reachToMap.put(startCity, new ArrayList<>());
            }
            reachToMap.get(startCity).add(endCity);

            if (!reachHereMap.containsKey(endCity)) {
                reachHereMap.put(endCity, new ArrayList<>());
            }
            reachHereMap.get(endCity).add(startCity);
        }


        boolean[] reachable = new boolean[n];
        reachable[0] = true;

        boolean[] isVisited = new boolean[n];

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);

        int needChange = 0;

        while (!queue.isEmpty()) {
            int goalCity = queue.poll();
            isVisited[goalCity] = true;
            // System.out.println("Goal city: " + goalCity);

            ArrayList<Integer> reachTo = reachToMap.get(goalCity);
            if (reachTo != null) {
                for (int city : reachTo) {
                    // 说明，俩城市之间有一条路线，需要改变方向， goal -> end
                    if (!reachable[city]) {
                        needChange++;
                    }
                    reachable[city] = true;
                    if (!isVisited[city]) {
                        queue.offer(city);
                    }
                }
            }

            ArrayList<Integer> reachHere = reachHereMap.get(goalCity);
            if (reachHere != null) {
                for (int city : reachHere) {
                    reachable[city] = true;
                    if (!isVisited[city]) {
                        queue.offer(city);
                    }
                }
            }
        }
        return needChange;
    }
}

/*
BFS遍历一遍城市，从0开始。
如果城市能到达0，说明这个城市是可达的，标记为可达，标记已访问，加入队列。
如果能从0到达该城市，需要翻转路线，needChange++，并且标记为可达，标记已访问，加入队列。
依次类推。
从前往后遍历，如果能到达一个 可达的城市，说明这个城市也是可达的，标记为可达，标记已访问，加入队列。

最后可能因为有很多个城市导致超时，所以用两个map来存储城市之间的关系，减少遍历次数。
 */