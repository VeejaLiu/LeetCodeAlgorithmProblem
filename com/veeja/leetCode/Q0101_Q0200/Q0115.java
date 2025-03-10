package com.veeja.leetCode.Q0101_Q0200;

/**
 * 115. 不同的子序列
 * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 10^9 + 7 取模。
 * <p>
 * 示例 1：
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * rabbbit
 * rabbbit
 * rabbbit
 * <p>
 * 示例 2：
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 */
public class Q0115 {
}

/*
尝试动态规划
         b     ba     bag
b        1     0      0
ba       1     1      0
bab      2     1      0
babg     2     1      1
babgb    3     1      1
babgba   3     4      1
babgbag  3     4      5


结尾相等的话，
dp[i][j] = d[i-1][j-1] + 1


最终结果 babgba     ba    4

去掉 a
babgb b -> 3
去掉 ba
babg "" -> 1
 */