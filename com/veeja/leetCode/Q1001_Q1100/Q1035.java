package com.veeja.leetCode.Q1001_Q1100;


/**
 * 1035. 不相交的线
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足：
 * nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 */
public class Q1035 {
    public static void main(String[] args) {

        int[] aaa = new int[]{1, 3, 5};
        int[] bbb = new int[]{1, 5, 3};
        System.out.println("上题计算结果 = " + test(aaa, bbb));
        System.out.println();

        aaa = new int[]{1, 1, 2, 1};
        bbb = new int[]{3, 3, 1};
        System.out.println("上题计算结果 = " + test(aaa, bbb));
        System.out.println();

        aaa = new int[]{3, 3, 2, 3, 3};
        bbb = new int[]{1, 3, 1, 2};
        System.out.println("上题计算结果 = " + test(aaa, bbb));
        System.out.println();

        aaa = new int[]{1, 4};
        bbb = new int[]{3, 5};
        System.out.println("上题计算结果 = " + test(aaa, bbb));


    }


    private static int test(int[] first, int[] second) {
        int[][] result = new int[first.length + 1][second.length + 1];
        for (int i = 1; i <= first.length; i++) {
            for (int j = 1; j <= second.length; j++) {
                if (first[i - 1] == second[j - 1]) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
//                printArray(result);
            }
        }
//        System.out.println(result[first.length][second.length]);
//        System.out.println("========================================");
        return result[first.length][second.length];
    }

    private static void printArray(int[][] result) {
        System.out.println("状态转移过程：");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----");
    }
}

/*
    1  3  5
 1  1  1  1
 5  1  1  2
 3  1  2  2

状态转移 类似于：
如果最后一位相等， dp[i][j] = dp[i-1][j-1] + 1
如果最后一位不相等： 则 dp[i][j] = max( dp[i-1][j], dp[i][j-1] )

返回值就是 dp的最后一个元素
 */