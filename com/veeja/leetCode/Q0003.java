package com.veeja.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author veeja
 * 2021/1/31 12:52
 */
public class Q0003 {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("efabcdefgabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));

    }


    private static int lengthOfLongestSubstring(String s) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        int head = 0;
        int tail = 0;

        for (; head < s.length(); head++) {
            // 取出Head所在位置的字符
            Character character = s.charAt(head);
            if (map.containsKey(character)) {
                Integer temEnd = map.get(character);
                for (; tail <= temEnd; tail++) {
                    map.remove(s.charAt(tail));
                }
            }
            // 将字符存入Map
            map.put(character, head);
            // 计算此时子串长度
            int temLength = head - tail + 1;
            // 取最大值
            result = temLength > result ? temLength : result;
        }
        return result;
    }





    /*
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int tem = 0;
            for (int j = i; j < s.length(); j++) {
                if (!map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), s.charAt(j));
                    tem++;
                } else {
                    map.clear();
                    break;
                }
            }
            if (tem > result) {
                result = tem;
                tem = 0;
            }
        }
        return result;
    }
    */
}
