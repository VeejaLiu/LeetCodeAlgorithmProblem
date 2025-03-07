package com.veeja.leetCode.Q0501_Q0600;

import com.veeja.leetCode.util.ArrayUtil;
import org.junit.Test;

/**
 * 516. 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * <p>
 * 示例 1：
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成
 */
public class Q0516 {
    @Test
    public void test() {
        String[] strArray = {
//                "bbbab",
//                "cbbd",
                "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"
        };

        for (String str : strArray) {
            System.out.println("str = " + str + ", longestPalindromeSubseq = " + longestPalindromeSubseq(str));
        }
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            // 初始化，每个字符本身就是一个回文子序列
            dp[i][i] = 1;
        }
//        ArrayUtil.printArray(dp);

        int maxLen = 1;


        // L 表示子串的长度
        for (int L = 2; L <= n; L++) {
//            System.out.println("L = " + L);
            // start 表示 子串的起始位置
            for (int start = 0; start < n; start++) {
                // end 表示 子串的结束位置
                int end = start + L - 1;
                // 如果 end >= n，说明已经越界，结束循环
                if (end >= n) {
                    break;
                }

//                System.out.println("start = " + start + ", end = " + end);
//                System.out.println("s.charAt(start) = " + s.charAt(start) + ", s.charAt(end) = " + s.charAt(end));

                if (s.charAt(start) == s.charAt(end)) {
                    if (end - start == 1) {
                        // 如果i j 相邻
                        dp[start][end] = 2;
                    } else {
                        // 如果i j 不相邻，找出 dp[start + 1][end - 1] + 2
                        dp[start][end] = dp[start + 1][end - 1] + 2;
                    }
                } else {
                    // 如果i j 不相等
                    dp[start][end] = dp[start][end - 1];
                }

//                ArrayUtil.printArray(dp);

                if (dp[start][end] > maxLen) {
                    maxLen = dp[start][end];
                }
            }
        }

//        ArrayUtil.printArray(dp);

        return maxLen;
    }
}

/*
解题思路:

dp[i][j] 表示 s 的下标 i 到 j 的子串中，最长回文子序列的长度。
例如：
0  1  2  3  4
b  b  b  a  b

首先所有的 i == j 的位置都是 1，因为任何一个字符本身就是一个回文子序列。
我们可以得到表:
         b  b  b  a  b
    (i)  0  1  2  3  4
 (j) |-------------------
b 0  |   1  0  0  0  0
b 1  |   0  1  0  0  0
b 2  |   0  0  1  0  0
a 3  |   0  0  0  1  0
b 4  |   0  0  0  0  1

 开始循环，
 */
