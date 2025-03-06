package com.veeja.leetCode.util;

/**
 * @author liuweijia
 */
public class ArrayUtil {
    public static void printArray(int[] result) {
        for (int j : result) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static String toString(int[] result) {
        StringBuilder s = new StringBuilder();
        for (int j : result) {
            s.append(j).append(" ");
        }
        return s.toString();
    }

    public static void printArray(int[][] result) {
        for (int[] i : result) {
            printArray(i);
        }
    }
}
