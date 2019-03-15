package com.hjdong.leetcode;

public class ReverseInteger {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.abs(Integer.MIN_VALUE));
        
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(-123954));
    }

    //假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
    public int reverse(int x) {
        if (0 == x) {
            return 0;
        }
        boolean isNeg = x < 0? true: false;
        String sx = String.valueOf(Math.abs((long)x));
        StringBuilder sb = new StringBuilder();
        for (int i = sx.length() - 1; i >=0; i--) {
            sb.append(sx.charAt(i));
        }
        
        long rx = Long.valueOf(sb.toString());
        if (isNeg) {
            if (rx > (long)Integer.MAX_VALUE + 1) {
                return 0;
            } else {
                return -1 * (int)rx;
            }
        } else {
            if (rx > Integer.MAX_VALUE) {
                return 0;
            } else {
                return (int)rx;
            }
        }
    }

}
