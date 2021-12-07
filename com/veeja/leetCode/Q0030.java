package com.veeja.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串s和一些长度相同的单词words。找出 s 中恰好可以由words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与words 中的单词完全匹配，中间不能有其他字符，但不需要考虑words中单词串联的顺序。
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 *
 * @Author veeja
 * 2021/1/28 19:42
 */
public class Q0030 {

    public static void main(String[] args) {

        demo1();
        demo2();
        demo3();

    }

    private static void demo1() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "word"};
        List<Integer> substring = findSubstring(s, words);
        System.out.println(substring);
    }

    private static void demo2() {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> substring = findSubstring(s, words);
        System.out.println(substring);
    }

    private static void demo3() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};
        List<Integer> substring = findSubstring(s, words);
        System.out.println(substring);
    }


    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();

        int length = words[1].length();
        // i 起始位置
        for (int i = 0; i < s.length() - length; i++) {
            List<String> wordsList = new ArrayList<>();
            for (String word : words) {
                wordsList.add(word);
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int after = 0; after < length; after++) {
                char x = s.charAt(i + after);
                stringBuffer.append(x);
            }
            String string = stringBuffer.toString();
            if (!wordsList.contains(string)) {
                continue;
            } else {
                int flag = 1;
                if (flag == 0) {
                    continue;
                }
                for (int j = i; j < s.length() - length; j += length) {
                    StringBuffer stringBuffer1 = new StringBuffer();
                    for (int after = 0; after < length; after++) {
                        char x = s.charAt(i + after);
                        stringBuffer1.append(x);
                    }
                    String string1 = stringBuffer1.toString();
                    if (wordsList.contains(string1)) {
                        wordsList.remove(string1);
                        if (wordsList.isEmpty()) {
                            flag = 0;
                            result.add(i);
                        }
                        continue;
                    } else {
                        flag = 0;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
