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

/*
动态规划，
dp[i][j] 表示 s[i..j] 是否是回文子串
首先每个字符本身都是回文子串，所以 dp[i][i] = true
我们用 babab 举例：
```
    b a b a b
b   1 0 0 0 0
a     1 0 0 0
b       1 0 0
a         1 0
b           1

下半区是不存在的，因为从1到3，但是没有从3到1，这是没有意义的。
然后我们可以找到状态转移方程：
如果遍历到了 i, j
首先是 如果 s[i] != s[j], [i..j] 肯定不是个回文子串，所以 dp[i][j] = false
如果 s[i] == s[j], 那么 dp[i][j] = dp[i + 1][j - 1] + 2
怎么理解呢，比如：
baab, 如果 i=0 (b), j=3 (b), 此时，s[i] 是等于 s[j]的，那么 dp[0][3] = dp[1][2]
相当于，如果 dp[1][2] 是回文子串，那么在原本的回文串的首尾加上一个相同的字符，新的子串自然也是回文串
如果 dp[1][2] 不是回文子串, 那么 dp[0][3] 也不是回文子串。
然后讨论一下边界情况：
如果 i == j, 那么 dp[i][j] = true，因为一个字符肯定是回文子串
然后如果 i + 1 == j, 那么 dp[i][j] = (s[i] == s[j])，因为两个字符相邻，那么就取决于这俩字符串是否是一个字符。

然后遍历的时候，我们从不同的长度，然后不停地从头到尾遍历就可以了。
 */