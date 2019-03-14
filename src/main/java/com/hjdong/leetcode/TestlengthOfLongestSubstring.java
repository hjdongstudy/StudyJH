package com.hjdong.leetcode;

public class TestlengthOfLongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestlengthOfLongestSubstring t = new TestlengthOfLongestSubstring();
		System.out.println(t.lengthOfLongestSubstring("as"));
	}
	
	public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() ==0) {
        	return 0;
        }
        
        if (s.length() == 1) {
        	return 1;
        }
        int maxl = 1;
        for (int i = 0; i < s.length() - 1 ; ) {
        	int indexOf = -1;
        	for (int j = i + 1; j < s.length(); j ++) {
        		indexOf = s.substring(i, j).indexOf(s.substring(j, j + 1));
				if (-1 == indexOf) {
        			maxl = j - i + 1 >maxl? j - i + 1:maxl;
        		} else {
        			break;
        		}
        	}
        	if (indexOf > i) {
        		i = indexOf + 1;
			} else {
				i ++;
			}
        }
        
        return maxl;
    }

}
