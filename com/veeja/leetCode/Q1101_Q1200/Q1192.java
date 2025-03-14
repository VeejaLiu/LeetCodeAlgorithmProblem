package com.veeja.leetCode.Q1101_Q1200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO uncompleted
 * 1192. 查找集群内的关键连接
 * 力扣数据中心有 n 台服务器，
 * 分别按从 0 到 n-1 的方式进行了编号。
 * 它们之间以 服务器到服务器 的形式相互连接组成了一个内部集群，连接是无向的。
 * 用  connections 表示集群网络，
 * connections[i] = [a, b] 表示服务器 a 和 b 之间形成连接。
 * 任何服务器都可以直接或者间接地通过网络到达任何其他服务器。
 * 关键连接 是在该集群中的重要连接，假如我们将它移除，
 * 便会导致某些服务器无法访问其他服务器。
 * 请你以任意顺序返回该集群内的所有 关键连接 。
 */
public class Q1192 {

    @Test
    public void test() {
        int n = 4;
        ArrayList<List<Integer>> connections = new ArrayList<>();
        connections.add(new ArrayList<Integer>() {{
            add(0);
            add(1);
        }});
        connections.add(new ArrayList<Integer>() {{
            add(1);
            add(2);
        }});
        connections.add(new ArrayList<Integer>() {{
            add(2);
            add(0);
        }});
        connections.add(new ArrayList<Integer>() {{
            add(1);
            add(3);
        }});
        /*
        0--1--3
         \ |
          \|
           2
            示例 1：
            输入：n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
            输出：[[1,3]]
            解释：[[3,1]] 也是正确的。
         */
        System.out.println(criticalConnections(n, connections));
    }

    @Test
    public void test2() {
        int n = 2;
        ArrayList<List<Integer>> connections = new ArrayList<>();
        connections.add(new ArrayList<Integer>() {{
            add(0);
            add(1);
        }});
        System.out.println(criticalConnections(n, connections));
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

    }
}

/*
有个简单的想法，好像能形成环的，都不是关键连接。
所以可以找出所有的环，然后删掉所有的环的边，剩下的就是关键连接。
 */