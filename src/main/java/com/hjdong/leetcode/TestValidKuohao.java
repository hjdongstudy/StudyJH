package com.hjdong.leetcode;

public class TestValidKuohao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestValidKuohao vk = new TestValidKuohao();
		System.out.println(vk.isValid(""));
	}

	public boolean isValid(String s) {
		if (null == s) {
			return false;
		}
		if (s.equals("")) {
			return true;
		}
		
		char[] stack = new char[s.length()];
		int topindex = -1;
		for(int i = 0; i < s.length(); i ++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				topindex ++;
				stack[topindex] = s.charAt(i);
			} else {
				if (s.charAt(i) == ')' ) {
					if (topindex < 0 || stack[topindex] != '(') {
						return false;
					} else {
						stack[topindex] = (char)0;
						topindex --;
					}
					
				} else if (s.charAt(i) == ']' ) {
					if (topindex < 0 || stack[topindex] != '[') {
						return false;
					} else {
						stack[topindex] = (char)0;
						topindex --;
					}
				} else if (s.charAt(i) == '}' ) {
					if (topindex < 0 || stack[topindex] != '{') {
						return false;
					} else {
						stack[topindex] = (char)0;
						topindex --;
					}
				} else {
					return false;
				}
			}
			
		}
		
		if (0 == (int)stack[0]) {
			return true;
		} else {
			return false;
		}
    }
}
