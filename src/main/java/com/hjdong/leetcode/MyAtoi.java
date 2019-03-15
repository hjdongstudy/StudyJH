package com.hjdong.leetcode;

public class MyAtoi {
    public static void main(String[] args) {
     
        MyAtoi ma = new MyAtoi();
        System.out.println(ma.myAtoi("20000000000000000000"));
    }
    
    public int myAtoi(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean isS = false;
        boolean isNeg = false;
        boolean hasFNotZero = false;
        for (int i = 0; i < str.length(); i ++) {
            if (!isS) {
                if (' ' == str.charAt(i)) {
                    continue;
                }
                if ('-' == str.charAt(i)) {
                    isS = true;
                    isNeg = true;
                    continue;
                }
                if ('+' == str.charAt(i)) {
                    isS = true;
                    continue;
                }
                
                if (str.charAt(i) == '0') {
                    isS = true;
                    continue;
                } else if (str.charAt(i) >= '1' && str.charAt(i) <= '9') {
                    isS = true;
                    hasFNotZero = true;
                    sb.append(str.charAt(i));
                    continue;
                }
                return 0;
            } else {
                if (str.charAt(i) == '0') {
                    if (hasFNotZero) {
                        sb.append(str.charAt(i));
                    }
                } else if (str.charAt(i) >= '1' && str.charAt(i) <= '9') {
                    hasFNotZero = true;
                    sb.append(str.charAt(i));
                } else {
                    break;
                }
            }
        }
        
        if (sb.length() == 0) {
            return 0;
        } else if (sb.length() > 10) {
            if (isNeg) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        } else {
            long l = Long.valueOf(sb.toString());
            if (isNeg) {
                if (l > (long)Integer.MAX_VALUE + 1) {
                    return Integer.MIN_VALUE;
                } else {
                    return -1 * (int)l;
                }
            } else {
                if (l > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else {
                    return (int)l;
                }
            }
        }
    }
}
