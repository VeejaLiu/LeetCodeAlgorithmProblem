package com.veeja.leetCode.Q0801_Q0900;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 841. 钥匙和房间
 * 有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。
 * 你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
 * 当你进入一个房间，你可能会在里面找到一套 不同的钥匙，
 * 每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
 * 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。
 * 如果能进入 所有 房间返回 true，否则返回 false。
 */
public class Q0841 {
    @Test
    public void test() {
        // 测试用例：[[1],[2],[3],[]]
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1));
        rooms.add(List.of(2));
        rooms.add(List.of(3));
        rooms.add(new ArrayList<>());

        System.out.println(canVisitAllRooms(rooms)); // 应输出 true
    }

    public void dfs(List<List<Integer>> rooms, int i, int[] isVisited) {
        if (isVisited[i] == 1) {
            return;
        }
        isVisited[i] = 1;
        List<Integer> room = rooms.get(i);
        for (Integer key : room) {
            dfs(rooms, key, isVisited);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] isVisited = new int[rooms.size()];
        dfs(rooms, 0, isVisited);
        for (int i = 0; i < isVisited.length; i++) {
            if (isVisited[i] == 0) {
                return false;
            }
        }

        return true;
    }

}

/*
从0开始深度搜索即可，找到最后如果还有没有访问的房间返回false，否则返回true。
 */
