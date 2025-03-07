package com.veeja.leetCode.util;

/**
 * @author liuweijia
 */
public class ArrayUtil {
    public static void printArray(int[] result) {
        System.out.print("[ ");
        for (int j : result) {
            System.out.print(j + " ");
        }
        System.out.println("]");
    }

    private static void printArray(boolean[] i) {
        System.out.print("[ ");
        for (boolean j : i) {
            System.out.print((j ? "T" : "F") + " ");
        }
        System.out.println("]");
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

    public static void printArray(boolean[][] result) {
        for (boolean[] i : result) {
            printArray(i);
        }
    }

}
