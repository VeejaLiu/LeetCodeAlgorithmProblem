package com.veeja.leetCode.Q0001_Q0100;

import org.junit.Test;

import java.util.HashSet;

/**
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 * <p>
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class Q0005 {

    @Test
    public void test() {
        System.out.println(longestPalindrome("bababd"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("acaca"));
        System.out.println(longestPalindrome("abba"));
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
