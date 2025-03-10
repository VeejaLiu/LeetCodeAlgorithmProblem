package com.veeja.leetCode.Q0001_Q0100;

import com.veeja.leetCode.util.ArrayUtil;
import org.junit.Test;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 示例 1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * 示例 2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class Q0072 {

    @Test
    public void test() {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        ArrayUtil.printArray(dp);

        // 边界情况
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        ArrayUtil.printArray(dp);

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.println("i = " + i + ", j = " + j);
                // A[0...i]
                System.out.println("A[0...i] = " + word1.substring(0, i));
                // B[0...j]
                System.out.println("B[0...j] = " + word2.substring(0, j));


                // 如果 A[0...i] 和 B[0...j] 的最后一个字母相同，那么 D[i][j] = min( D[i-1][j] + 1, D[i][j-1] + 1, D[i-1][j-1] )
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1]);
                } else {
                    // 如果 A[0...i] 和 B[0...j] 的最后一个字母不同，那么
                    // D[i][j] = min(
                    //    D[i-1][j] + 1,  // 删除 A 的最后一个字母
                    //    D[i][j-1] + 1,  // 删除 B 的最后一个字母
                    //    D[i-1][j-1] + 1 // 替换 A 的最后一个字母为 B 的最后一个字母
                    // )
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }

                ArrayUtil.printArray(dp);
            }
        }
        return dp[m][n];

    }
}

/*
求最长公共子序列?

不是。

看题解吧，

得到的dp是
“我们用 D[i][j] 表示 A 的前 i 个字母和 B 的前 j 个字母之间的编辑距离。”

让我尝试理解一下，

比如 A 是 "horse", B 是 "ros",

我们列出这样的一个表格

       (B)j      0    1     2
                "r"  "ro" "ros"
   (A) i     -------------------
 0     "h"   |   1
 1    "ho"   |
 2   "hor"   |
 3  "hors"   |
 4 "horse"   |

首先，D[0][0] 在这个例子中自然是 1。 因为 r 和 h 之间的编辑距离是 1（一次替换）。

那么： 从 h -> r 需要 1 步， 进行替换即可。
      从 ho -> r 需要 2 步， 先替换再删除或者先删除再替换都可以。
      以此类推，hor -> r 需要 3 步, hors -> r 需要 4 步, horse -> r 需要 5 步。
反过来也是一样的，r -> h 需要 1 步，ro -> h 需要 2 步，ros -> h 需要 3 步。

我们就可以得到这个表格：
       (B)j      0    1     2
                "r"  "ro" "ros"
   (A) i     -------------------
 0     "h"   |   1    2     3
 1    "ho"   |   2
 2   "hor"   |   3
 3  "hors"   |   4
 4 "horse"   |   5


接下来讨论 D[1][1], 也就是 ho -> ro 的编辑距离。
从 ho -> ro，我们有三种路径，
- 从 ho -> r -> ro     ho -> r 的距离为 2, 所以在这条路径上，ho -> ro 的距离为 3
- 或者 ro -> h -> ho   ro -> h 的距离为 2, 所以 在这条路径上，ro -> ho 的距离为 3
- 另外我们其实可以用肉眼来看，ho -> ro 的距离为 1，因为只需要替换 h 为 r 即可。
  我们来想一下这个思维在矩阵中的含义，因为 ho ro 都是以 o 结尾，所以这个 o 是没有意义的。
  那就意味着 ho -> ro 的距离就是 h -> r 的距离，也就是 1。

以上的三种路径中，我们取其最小值即可。
这个时候我们可以得到一个结论了：
如果 A[0...i] 和 B[0...j] 的最后一个字母相同，那么 D[i][j] = min( D[i-1][j] + 1, D[i][j-1] + 1, D[i-1][j-1] )
在这个例子中， ho -> ro = min(3, 3, 1) = 1

但是如果是"in" -> "ex"呢？也就是最后一个字母不相同的情况。
我们先列个表：
     (B)j        0     1
                "e"   "ex"
(A) i     -----------------
 0     "i"   |   1     2
 1    "in"   |   2

从 in -> ex, 我们也有三种路径：
- in -> e -> ex     in -> e 的距离为 2, 所以 in -> ex 的距离为 3
- ex -> i -> in     ex -> i 的距离为 2, 所以 ex -> in 的距离为 3
上面这两种方案都是先删除，再替换，再增加，都是绕远路的办法。
但是实际上，我们可以直接替换 n 为 x，替换 i 为 e，这样就可以得到最短路径 = 2。
我们再来思考其背后的含义，其实也很简单：
我们只看最后一个字母，就是 n -> x，我们直接将其替换就可以了。
这个时候前面的 i -> e, 也直接替换就可以了，所以其距离就是这两次替换，也就是 2。
也就是说, 在这种路径下，D[i][j] = D[i-1][j-1] + 1
综合上面的来看，我们可以得到一个结论：
如果 A[0...i] 和 B[0...j] 的最后一个字母不同，那么
D[i][j] = min(
    D[i-1][j] + 1,  // 删除 A 的最后一个字母
    D[i][j-1] + 1,  // 删除 B 的最后一个字母
    D[i-1][j-1] + 1 // 替换 A 的最后一个字母为 B 的最后一个字母
)

边界情况就是 如果要比较一个空的字符串与一个非空的字符串，那么编辑距离就是非空字符串的长度。
 */