package com.veeja.leetCode.Q0701_Q0800;

import com.veeja.leetCode.util.ArrayUtil;
import org.junit.Test;

/**
 * 712. 两个字符串的最小ASCII删除和
 * 给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。
 * <p>
 * 示例 1:
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 * <p>
 * 示例 2:
 * 输入: s1 = "delete", s2 = "leet"
 * 输出: 403
 * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
 * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
 * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
 * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 */
public class Q0712 {

    @Test
    public void test() {
        String[][] cases = {
                {"sea", "eat"}, {"delete", "leet"},
                };
        for (String[] strings : cases) {
            System.out.println("Test case: " + strings[0] + ", " + strings[1]);
            System.out.println(minimumDeleteSum(strings[0], strings[1]));
        }
    }

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
                } else if (i == 0) {
                    dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + s2.charAt(j - 1), dp[i - 1][j] + s1.charAt(i - 1));
                }
            }
        }
        return dp[m][n];
    }
}

/*
尝试动态规划:
    [j]   0       1        2        3
          ""      e        ea       eat
[i]     --------------------------------
 0   "" | ""      e        e+a      e+a+t
 1    s | s       s+e      s+e+a    s+e+a+t
 2   se | s+e     s        s+a      s+a+t
 3  sea | s+e+a   s+a


貌似是:
如果 s1[i] == s2[j], 那么 dp[i][j] = dp[i-1][j-1]
如果 s1[i] != s3[j], 那么 dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]

也许可以再找个例子:
delete 和 leet
      s2 [j]   0              1        2        3            4
               ""             l        le       lee          leet
 s1 [i]     --------------------------------------------------------------
 0      ""  |  ""             l        l+e      l+e+e        l+e+e+t
 1       d  |  d              d+l      d+l+e    d+l+e+e      d+l+e+e+t
 2      de  |  d+e            d+e+l    d+l      d+l+e        d+l+e+t
 3     del  |  d+e+l          d+e      d+e+e(d+l+l)
 4    dele  |  d+e+l+e
 5   delet  |  d+e+l+e+t
 6  delete  |  d+e+l+e+t+e


 妈的观察了一会，还是没观察出来，查看了题解，发现方程是：
 如果 s1[i] == s2[j], 那么 dp[i][j] = dp[i-1][j-1]
 如果 s1[i] != s2[j], 那么 dp[i][j] = min(dp[i][j-1] + s2[j], dp[i-1][j] + s1[i])
 */