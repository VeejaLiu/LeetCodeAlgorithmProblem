package com.veeja.leetCode.Q1101_Q1200;

import org.junit.Test;

/**
 * 1143. 最长公共子序列
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * 示例 1：
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * <p>
 * 示例 2：
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * <p>
 * 示例 3：
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 */
public class Q1143 {
    @Test
    public void test() {

        String[][] cases = {
                // {}
                {"abcde", "ace"}, {"abc", "abc"}, {"abc", "def"}
        };

        for (String[] strings : cases) {
            System.out.println("Test case: text1 = " + strings[0] + ", text2 = " + strings[1]);
            System.out.println(longestCommonSubsequence(strings[0], strings[1]));
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        // 初始化
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 如果 text1[i] == text2[j]，取左上角的值加1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果 text1[i] != text2[j]，取左边和上边的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}

/*
尝试动态规划求解：

那么 dp[i][j] 表示 text1[0:i] 和 text2[0:j] 的最长公共子序列的长度。

如 text1 = "abcde", tesx2 = "ace"

        [j]    0        1       2
               "a"      "ac"    "ace"
[i]         -------------------------
 0     "a"  |  1         1      1
 1    "ab"  |  1         1      1
 2   "abc"  |  1         2      2
 3  "abcd"  |  1         2      2
 4 "abcde"  |  1         2      3


好像是可以的，那么我们可以得到状态转移方程：
如果 text1[i] == text2[j]，那么 dp[i][j] = dp[i-1][j-1] + 1
如果 text1[i] != text2[j]，那么 dp[i][j] = max(dp[i-1][j], dp[i][j-1])
 */