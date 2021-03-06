package com.veeja.leetCode;

/**
 * @Author veeja
 * 2021/1/27 8:28
 */
public class Q136 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        int i = singleNumber(nums);
        System.out.println(i);

    }


    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result = result ^ i;
        }
        return result;
    }
}