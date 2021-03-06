package com.veeja.leetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @Author veeja
 * 2021/1/29 16:44
 */
public class Q0001 {


    public static void main(String[] args) {

//        int[] nums = {2, 7, 11, 15};
//        int target = 9;

        int[] nums = {3, 2, 4};
        int target = 6;
//
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;


        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    /*
     * 废物！
    public static int[] twoSum(int[] nums, int target) {
        int[] result = {0, 0};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
     */


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}