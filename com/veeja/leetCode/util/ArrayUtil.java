package com.veeja.leetCode.util;

/**
 * @author liuweijia
 */
public class ArrayUtil {
    public static void printArray(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static String toString(int[] result) {
        String s = "";
        for (int i = 0; i < result.length; i++) {
            s += result[i] + " ";
        }
        return s;
    }
}
