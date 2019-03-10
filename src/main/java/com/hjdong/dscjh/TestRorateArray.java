package com.hjdong.dscjh;

import java.util.Arrays;

public class TestRorateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] {1,2,3,4,5,6};
		a = rotate(a, 4);
		System.out.println(Arrays.toString(a));
	}

	private static int[] rotate(int[] a, int k) {
		if (a.length == 0 || (k %= a.length) == 0) return a;
        int n = a.length, start = 0, i = 0, cur = a[i], cnt = 0;
        while (cnt++ < n) {
            i = (i + k) % n;
            int t = a[i];
            a[i] = cur;
            if (i == start) { //这个条件的作用是什么？？
                ++start; ++i;
                cur = a[i];
            } else {
                cur = t;
            }
        }
        return a;
	}

}
