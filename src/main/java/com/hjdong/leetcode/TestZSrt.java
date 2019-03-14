package com.hjdong.leetcode;

public class TestZSrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestZSrt tzs = new TestZSrt();
		System.out.println(tzs.convert("A", 1));
	}
	
	public String convert(String s, int numRows) {
		if (null == s || numRows == 1) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i ++) {
			int j = i;
			int rc = 0;
			if (i == 0 || i == numRows -1) {
				rc = numRows -1;
			} else {
				rc = numRows - i - 1;
			}
			while(j < s.length()) {
				sb.append(s.charAt(j));
				j = rc * 2 + j;
				if (i == 0 || i == numRows -1) {
				} else {
					rc = numRows - rc -1;
				}
			}
		}
		return sb.toString();
    }

}
