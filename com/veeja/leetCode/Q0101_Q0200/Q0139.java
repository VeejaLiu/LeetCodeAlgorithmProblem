package com.veeja.leetCode.Q0101_Q0200;

import org.junit.Test;

import java.util.List;

/**
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * <p>
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * <p>
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * s = "applenth"
 * wordDict = ["app" ,"apple", "len", "lenth"]
 */
public class Q0139 {

    @Test
    public void test() {
        System.out.println(wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
        System.out.println(wordBreak("applenth", List.of("app", "apple", "len", "lenth")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();

        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
//            System.out.println("i: " + i);
            // 子字符串
            String subStr = s.substring(0, i + 1);
//            System.out.println("subStr: " + subStr);
            // 判断从头到这个位置的子字符串是否在单词本里面
            if (wordDict.contains(subStr)) {
                dp[i] = 1;
                continue;
            }

            // 如果不在，那么就要判断是否可以拆分
            // 将subStr分别减去单词本里面的单词，然后判断前面的部分是否可以拆分
            for (String word : wordDict) {
                // 这里有个条件是 subStr 以 word 结尾，否则拆分就没有意义
                if (subStr.endsWith(word)) {
                    // subStr 减去 word 之后的子字符串
                    String subSubStr = subStr.substring(0, subStr.length() - word.length());
                    // 如果前面的部分可以拆分，那么这个部分也可以拆分
                    if (dp[subSubStr.length() - 1] == 1) {
                        dp[i] = 1;
                        break;
                    }
                }
            }
        }
        return dp[len - 1] == 1;
    }
}

/*
既然是动态规划，我们就尝试来找出状态转移方程。
我目前一个简答的想法是，
从前往后找, 一个一个字母的累加到字符串里面。
我们举个例子，

s = "applenth"
wordDict = ["app" ,"apple", "len", "lenth"]

从第一个字母开始，那就是一个字母组成的一个单词，找找这个单词是否出现在单词本里面。
首先是s[0] = 'a'， 'a' 当然不在字符串里面，所以 dp[0] = false
这个时候我们必须引入 dp 数组了，这个dp 就是用来记录 从头一直到这个位置的子字符串 是否可以被拆分。

然后是s[1] = 'p'， 'ap' 也不在单词本里面，所以 dp[1] = false
     s[2] = 'p', 'app' 在,                dp[2] = true
     s[3] = 'l', 'appl' 不在               dp[3] = false
一直到s[4] = 'e'， 'apple' 在单词本里面，所以 dp[4] = true

那么，再往后其实就能发现一个很有意思的点了：

当到了 s[5] = 'n' 的时候，
- 从头到尾，也就是 'applen' 并不在单词本里，所以 dp[5] = false 吗?
- 我们可以直观的观察到，'applen' 也许不在单词本里，但是 'app' + 'len' 在单词本里面，那么 dp[5] = true
  那么问题就是如果将这个过程数学化呢？
  其实也很简单，我们就将 applen 在其尾部，分别去掉单词本里的单词，然后检查，前面的部分是否可拆分，其实就是检查 dp[x] 是否为true
  也就是要满足两个条件：
  首先是去掉的部分要是一个单词，其次是前面的部分也要是可拆分。
  满足的话，那么 dp[5] = true

然后就从头遍历到尾就可以了。


当然优化吗，也是完全可以的。我懒得写了。
我想到的一种优化方式是从前往后直接刷新这个数组，而不用去剪掉某个单词之后再次判断。
比如，
dp[3] 是 true的情况下，我们直接判断从 4 往后，能否组成一个单词，能组成的，那么 dp[3 + 这个单词的长度] = true
这样好像能快一点点。
 */