package com.hjdong.leetcode;

import java.util.Arrays;

public class TestlongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestlongestPalindrome tl = new TestlongestPalindrome();
		System.out.println(tl.longestPalindrome("abacab"));
	}

	public String longestPalindrome(String s) {
		if (null == s || s.length() <= 1) {
			return s;
		}
		
		int[][] dpmatrix = new int[s.length()][s.length()];
		String reverseS = reseverStr(s);
		int max = 0;
		String maxhuiwen = null;
		String tmp = null;

		for (int i = 0; i < reverseS.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (reverseS.charAt(i) == s.charAt(j)) {
					if (i > 0 && j > 0) {
						dpmatrix[i][j] = 1 + dpmatrix[i - 1][j - 1];
						tmp = isHuiwen(s, reverseS, i, j, dpmatrix);
						if (null != tmp) { // 是回文时候才更新矩阵
							if (dpmatrix[i][j] > max) {
								max = dpmatrix[i][j];
								maxhuiwen = tmp;
							}
						}
					} else {
						dpmatrix[i][j] = 1;
						tmp = isHuiwen(s, reverseS, i, j, dpmatrix);
						if (null != tmp) { // 是回文时候才更新矩阵
							if (1 > max) {// 是回文时候才更新矩阵
								max = 1;
								maxhuiwen = tmp;
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < dpmatrix.length; i++) {
			System.out.println(Arrays.toString(dpmatrix[i]));
		}

		return maxhuiwen;
	}

	private String isHuiwen(String s, String reverseS, int i, int j, int[][] dpmatrix) {
		StringBuilder sb = new StringBuilder();
		int strL = dpmatrix[i][j];
		for (int k = 0; k < dpmatrix[i][j]; k ++) {
			if (s.length() -1 - i + k != j - strL + k + 1) {
				return null;
			} else {
				sb.append(reverseS.charAt(i - k));
			}
		}
		
		return sb.toString();
	}

	private String reseverStr(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

}
