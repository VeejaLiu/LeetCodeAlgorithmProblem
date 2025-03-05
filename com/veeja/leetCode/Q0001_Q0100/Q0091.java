package com.veeja.leetCode.Q0001_Q0100;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode Question
 *
 * @Author veeja
 * @date
 */
public class Q0091 {

    @Test
    public void test() {
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("100001"));
        System.out.println(numDecodings("11106"));
        System.out.println(numDecodings("0"));
        System.out.println(numDecodings("12"));
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        Set stringSet = new HashSet<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"));
        int result[] = new int[s.length()];
        if (s.length() == 1) {
            if (stringSet.contains(s)) {
                return 1;
            } else {
                return 0;
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (i == 0) {
                    if (stringSet.contains("" + s.charAt(i))) {
                        result[i] = 1;
                    } else {
                        return 0;
                    }
                } else {
                    int tem = 0;
                    if (stringSet.contains("" + s.charAt(i))) {
                        tem += result[i - 1];
                    }
                    if (stringSet.contains("" + s.charAt(i - 1) + s.charAt(i))) {
                        if (i == 1) {
                            tem += 1;
                        } else {
                            tem += result[i - 2];
                        }
                    }
                    if (tem == 0) {
                        return 0;
                    }
                    result[i] = tem;
                }
            }
        }
        return result[s.length() - 1];
    }
}
