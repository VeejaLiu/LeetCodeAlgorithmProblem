package com.veeja.leetCode;


/**
 * @Author veeja
 * @Email veejaliu@gmail.com
 * 2021/3/6 10:34
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
