package com.veeja.leetCode.Q0001_Q0100;

import com.veeja.leetCode.util.ArrayUtil;
import org.junit.Test;

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

        System.out.println("bababd: " + longestPalindrome("bababd"));
        System.out.println("cbbd: " + longestPalindrome("cbbd"));
        System.out.println("a: " + longestPalindrome("a"));
        System.out.println("aaaaaaa: " + longestPalindrome("aaaaaaa"));
        System.out.println("acaca: " + longestPalindrome("acaca"));
        System.out.println("abba: " + longestPalindrome("abba"));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
//        for (int i = 0; i < n; i++) {
//            // 初始化，每个字符本身就是一个回文子序列
//            dp[i][i] = true;
//        }
//        ArrayUtil.printArray(dp);

        int startIndex = 0;
        int maxLen = 1;


        // L 表示子串的长度
        for (int L = 1; L <= n; L++) {
//            System.out.println("L = " + L);
            // start 表示 子串的起始位置
            for (int start = 0; start < n; start++) {
                // end 表示 子串的结束位置
                int end = start + L - 1;
                // 如果 end >= n，说明已经越界，结束循环
                if (end >= n) {
                    break;
                }

//                System.out.println("start = " + start);
//                System.out.println("s.charAt(start) = " + s.charAt(start) + ", s.charAt(end) = " + s.charAt(end));

                if (s.charAt(start) == s.charAt(end)) {
                    if (end - start <= 1) {
                        // 如果i j 相邻 或者 i == j，那么 dp[i][j] = true
                        dp[start][end] = true;
                    } else {
                        // 如果i j 不相邻
                        if (dp[start + 1][end - 1]) {
                            // 如果 dp[i + 1][j - 1] 也是回文，那么 dp[i][j] = dp[i + 1][j - 1] + 2
                            dp[start][end] = true;
                        } else {
                            // 如果 dp[i + 1][j - 1] 不是回文，那么 dp[i][j] = 0
                            dp[start][end] = false;
                        }
                    }
                }

                if (dp[start][end] && (end - start + 1 > maxLen)) {
                    startIndex = start;
                    maxLen = end - start + 1;
                }

//                ArrayUtil.printArray(dp);
            }
        }


        return s.substring(startIndex, startIndex + maxLen);
    }
}