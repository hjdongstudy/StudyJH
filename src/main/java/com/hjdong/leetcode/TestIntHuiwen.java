package com.hjdong.leetcode;

public class TestIntHuiwen {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TestIntHuiwen t = new TestIntHuiwen();
        System.out.println(t.isPalindrome(1221));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int orix = x;
        
        long rx = x % 10;
        x = x / 10;
        
        while(x > 0) {
            rx = rx * 10 + x % 10;
            x = x / 10;
        }
        
        return rx == orix;
    }
}
