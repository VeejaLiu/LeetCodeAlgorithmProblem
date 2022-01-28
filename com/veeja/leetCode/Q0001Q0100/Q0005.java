package com.veeja.leetCode.Q0001Q0100;

import java.util.HashSet;

/**
 * @Author veeja
 * 2021/2/2 15:29
 */
public class Q0005 {

    public static void main(String[] args) {
        // System.out.println(longestPalindrome("bababd"));
        // System.out.println(longestPalindrome("cbbd"));
        // System.out.println(longestPalindrome("a"));
        // System.out.println(longestPalindrome("acaca"));
        System.out.println(longestPalindrome("abba"));
        HashSet hashSet = new HashSet<String>();
        hashSet.add("a");
    }

    public static String longestPalindrome(String s) {

        String result = "";
        int resultLength = 0;
        // 应付ABA形式的回文
        for (int i = 0; i < s.length(); i++) {
            int temLength = 1;
            String temResult = "";
            temResult += s.charAt(i);
            for (int j = 1; j <= s.length(); j++) {
                if ((i + j) <= s.length() - 1 && (i - j) >= 0 && s.charAt(i - j) == s.charAt(i + j)) {
                    temResult = s.charAt(i - j) + temResult + s.charAt(i - j);
                    temLength += 2;
                } else {
                    break;
                }
            }
            if (temLength > resultLength) {
                result = temResult;
                resultLength = temLength;
            }
        }

        // 应付ABBA形式的回文
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                continue;
            }
            int temLength = 2;
            String temResult = "";
            temResult = temResult + s.charAt(i) + s.charAt(i + 1);
            for (int j = 1; j <= s.length(); j++) {
                if ((i + 1 + j) <= s.length() - 1 && (i - j) >= 0 && s.charAt(i - j) == s.charAt(i + 1 + j)) {
                    temResult = s.charAt(i - j) + temResult + s.charAt(i - j);
                    temLength += 2;
                } else {
                    break;
                }
            }
            if (temLength > resultLength) {
                result = temResult;
                resultLength = temLength;
            }
        }
        return result;
    }
}
