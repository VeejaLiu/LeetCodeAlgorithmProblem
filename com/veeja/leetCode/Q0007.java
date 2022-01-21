package com.veeja.leetCode;

/**
 * @author liuweijia
 */
public class Q0007 {
    public static void main(String[] args) {
        // System.out.println("result:" + reverse(123) + "\n");
        // System.out.println("result:" + reverse(-123) + "\n");
        // System.out.println("result:" + reverse(0) + "\n");
        System.out.println("result:" + reverse(1534236469) + "\n");
    }

    public static int reverse(int x) {
        try {
            // System.out.println(x);
            int isNegative = x < 0 ? -1 : 1;
            x = isNegative * x;
            // System.out.println("取绝对值X：" + x);
            String s = String.valueOf(x);
            // System.out.println(s);
            String reverse = new StringBuffer(s).reverse().toString();
            int result = Integer.parseInt(reverse);
            return result * isNegative;
        } catch (NumberFormatException e) {
            return 0;
        }

    }
}
