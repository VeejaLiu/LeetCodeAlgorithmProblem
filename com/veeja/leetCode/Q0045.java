package com.veeja.leetCode;

import com.veeja.leetCode.util.ArrayUtil;

public class Q0045 {

    public static void main(String[] args) {
        int[] array1 = {2, 3, 1, 1, 4};
        int[] array2 = {2, 3, 0, 1, 4};
        int[] array3 = {2, 1};
        // System.out.println(jump(array1));
        // System.out.println(jump(array2));
        System.out.println(jump(array3));
    }

    /**
     * 从终点到起点的简单DP
     */
    public static int jump(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            int ability = nums[i];
            for (int j = 1; j <= ability; j++) {
                if (i + j >= nums.length) {
                    continue;
                }
                if ((result[i] == 0 || result[i + j] + 1 < result[i])) {
                    if (i + j < nums.length - 1 && result[i + j] == 0) {
                        continue;
                    }
                    result[i] = result[i + j] + 1;
                }
            }
            ArrayUtil.printArray(result);
        }


        return result[0];
    }
}
