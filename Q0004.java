package com.veeja.leetCode;

/**
 * @Author veeja
 * 2021/2/2 11:16
 */
public class Q0004 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {1, 2};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;

        int length = nums1.length + nums2.length;

        int point1 = 0;
        int point2 = 0;

        if (length % 2 == 0) {
            // 总数为偶数时
            for (int i = 0; i < length / 2 - 1; i++) {
                if (point2 == nums2.length) {
                    point1++;
                } else if (point1 == nums1.length) {
                    point2++;
                } else if (nums2[point2] <= nums1[point1]) {
                    point2++;
                } else if (nums1[point1] < nums2[point2]) {
                    point1++;
                }
            }
            for (int i = 0; i < 2; i++) {
                if (point2 == nums2.length) {
                    result += nums1[point1];
                    point1++;
                } else if (point1 == nums1.length) {
                    result += nums2[point2];
                    point2++;
                } else if (nums1[point1] <= nums2[point2]) {
                    result += nums1[point1];
                    point1++;
                } else if (nums2[point2] < nums1[point1]) {
                    result += nums2[point2];
                    point2++;
                }
            }
            result = result / 2;
        } else {
            // 总数为奇数时
            for (int i = 0; i < length / 2; i++) {
                if (point2 == nums2.length) {
                    point1++;
                } else if (point1 == nums1.length) {
                    point2++;
                } else if (nums2[point2] <= nums1[point1]) {
                    point2++;
                } else if (nums1[point1] < nums2[point2]) {
                    point1++;
                }
            }
            if (point2 == nums2.length) {
                result += nums1[point1];
                point1++;
            } else if (point1 == nums1.length) {
                result += nums2[point2];
                point2++;
            } else if (nums1[point1] <= nums2[point2]) {
                result += nums1[point1];
                point1++;
            } else if (nums2[point2] < nums1[point1]) {
                result += nums2[point2];
                point2++;
            }
        }
        return result;
    }


}
