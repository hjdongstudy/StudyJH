package com.hjdong.dscjh;

public class TestMaxSubStr {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s1 = "abcdefasdef";
        String s2 = "abefas";
        String ss = null,sl = null;
        if (s1.length() > s2.length()) {
            ss = s2;
            sl = s1;
        } else {
            ss = s1;
            sl = s2;
        }
        
        int max = 0; String maxSubStr = null;
        for (int i = 0; i < ss.length(); i ++) {
            if ((ss.length() - i) < max) {
                break;
            }
            for (int j = ss.length(); j > i; j --) {
                if (sl.indexOf(ss.substring(i, j)) != -1) {
                    if ((j - i) > max) {
                        max = j - i;
                        maxSubStr = ss.substring(i, j);
                        break;
                    }
                }
            }
        }
        
        System.out.println(max);
        System.out.println(maxSubStr);
    }

}
