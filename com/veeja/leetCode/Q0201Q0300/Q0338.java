package com.veeja.leetCode.Q0201Q0300;

import com.veeja.leetCode.util.ArrayUtil;
import org.junit.Test;

import java.util.ArrayList;

/**
 * LeetCode Question
 *
 * 找到规律，啥都好说。。。
 * result(0) = 0
 * n = 奇数， result(n) = result(n-1)+1
 * n = 偶数， result(n) = result(n/2)
 *
 * 别偷懒，在纸上写写，就能找到规律。
 *
 * @Author veeja
 * @date
 */
public class Q0338 {

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            System.out.println("countBits[i] = " + ArrayUtil.toString(countBits(i)));

        }
    }

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                result[i] = result[i / 2];
            } else {
                result[i] = result[i - 1] + 1;
            }
        }
        return result;
    }


}
