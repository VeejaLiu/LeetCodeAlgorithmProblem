package com.veeja.leetCode.Q0501_Q0600;

import org.junit.Test;

/**
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * <p>
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * - 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * - 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：s = "PPALLP"
 * 输出：true
 * 解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
 * 示例 2：
 * <p>
 * 输入：s = "PPALLL"
 * 输出：false
 * 解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。
 */
public class Q0551 {

    @Test
    public void test() {
        System.out.println(checkRecord("PPALLP"));
    }

    @Test
    public void test2() {
        System.out.println(checkRecord("PPALLL"));
    }

    public boolean checkRecord(String s) {
        int lateDays = 0;
        int absentDays = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'A':
                    absentDays++;
                    lateDays = 0;
                    break;
                case 'L':
                    lateDays++;
                    break;
                case 'P':
                    lateDays = 0;
                    break;
            }
            if (absentDays >= 2 || lateDays >= 3) {
                return false;
            }
        }
        return true;
    }
}


/*
水题。毫无意义。
唯一需要注意的是，迟到天数需要被清零。
 */