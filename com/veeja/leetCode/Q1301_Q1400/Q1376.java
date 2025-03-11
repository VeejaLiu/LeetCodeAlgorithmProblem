package com.veeja.leetCode.Q1301_Q1400;

import org.junit.Test;
import java.util.*;

/**
 * 1376. 通知所有员工所需的时间
 * 公司里有 n 名员工，每个员工的 ID 都是独一无二的，编号从 0 到 n - 1。公司的总负责人通过 headID 进行标识。
 * 在 manager 数组中，每个员工都有一个直属负责人，其中 manager[i] 是第 i 名员工的直属负责人。对于总负责人，manager[headID] = -1。题目保证从属关系可以用树结构显示。
 * 公司总负责人想要向公司所有员工通告一条紧急消息。他将会首先通知他的直属下属们，然后由这些下属通知他们的下属，直到所有的员工都得知这条紧急消息。
 * 第 i 名员工需要 informTime[i] 分钟来通知它的所有直属下属（也就是说在 informTime[i] 分钟后，他的所有直属下属都可以开始传播这一消息）。
 * 返回通知所有员工这一紧急消息所需要的 分钟数 。
 * <p>
 * 示例 1：
 * 输入：n = 1, headID = 0, manager = [-1], informTime = [0]
 * 输出：0
 * 解释：公司总负责人是该公司的唯一一名员工。
 * <p>
 * 输入：n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
 * 输出：1
 * 解释：id = 2 的员工是公司的总负责人，也是其他所有员工的直属负责人，他需要 1 分钟来通知所有员工。
 * 上图显示了公司员工的树结构。
 */
public class Q1376 {

    @Test
    public void test() {
        // 输入：n = 1, headID = 0, manager = [-1], informTime = [0]
        // 输出：0
        int n = 1;
        int headID = 0;
        int[] manager = {-1};
        int[] informTime = {0};
        System.out.println(numOfMinutes(n, headID, manager, informTime));
    }

    @Test
    public void test2() {
        // 输入：n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
        // 输出：1
        int n = 6;
        int headID = 2;
        int[] manager = {2, 2, -1, 2, 2, 2};
        int[] informTime = {0, 0, 1, 0, 0, 0};
        System.out.println(numOfMinutes(n, headID, manager, informTime));
    }

    @Test
    public void test3() {
        // 输入：n = 7, headID = 6, manager = [1,2,3,4,5,6,-1], informTime = [0,6,5,4,3,2,1]
        // 输出：21
        int n = 7;
        int headID = 6;
        int[] manager = {1, 2, 3, 4, 5, 6, -1};
        int[] informTime = {0, 6, 5, 4, 3, 2, 1};
        System.out.println(numOfMinutes(n, headID, manager, informTime));
    }


    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            // System.out.println("Employee ID: " + i + ", Manager ID: " + manager[i]);
            if (map.containsKey(manager[i])) {
                map.get(manager[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(manager[i], list);
            }
        }


        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(headID);

        int[] distance = new int[n];

        // 标记该员工是否已经被通知
        boolean[] isVisited = new boolean[n];
        isVisited[headID] = true;

        while (!queue.isEmpty()) {
            int head = queue.poll();
            // System.out.println("Current Employee ID: " + head);
            // get employees under the current employee
            ArrayList<Integer> employees = map.get(head);
            if (employees == null) {
                continue;
            }
            for (Integer employeeID : employees) {
                if (!isVisited[employeeID]) {
                    isVisited[employeeID] = true;
                    queue.offer(employeeID);
                    distance[employeeID] = distance[head] + informTime[head];
                }
            }
        }

        int maxValue = 0;
        for (int i : distance) {
            maxValue = Math.max(i, maxValue);
        }

        return maxValue;
    }
}
