package com.hjdong.dsc.sort;

import java.util.Arrays;

public class TestBaseSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testMpSort();
		testInserSort();
		testSelSort();
	}

	// 插入排序，a 表示数组，n 表示数组大小
	public static void testSelSort() {
		int[]  a= SortUtils.initRandomSortll(8);
		System.out.println(Arrays.toString(a));
		int n = 8;
		
		if (n <= 1)
			return;
		for (int i = 1; i < n; ++i) {
			int value = a[i];
			int j = i - 1;
			// 查找插入的位置
			for (; j >= 0; --j) {
				if (a[j] > value) {
					a[j + 1] = a[j]; // 数据移动
				} else {
					break;
				}
			}
			a[j + 1] = value; // 插入数据
		}
		
		System.out.println(Arrays.toString(a));
	}

	private static void testInserSort() {
		int[] testa = SortUtils.initRandomSortll(8);
		System.out.println(Arrays.toString(testa));
		int tmp, pos;
		for (int m = 1; m < testa.length; m++) {
			tmp = testa[m];
			pos = m;
			for (int n = m - 1; n >= 0; n--) {
				if (tmp < testa[n]) {
					testa[n + 1] = testa[n];
					pos = n;
				}
			}
			testa[pos] = tmp;
		}

		System.out.println(Arrays.toString(testa));

	}

	private static void testMpSort() {
		int[] testa = SortUtils.initRandomSortll(8);
		System.out.println(Arrays.toString(testa));
		int tmp;
		int mpC = 0;
		for (int m = 0; m < testa.length - 1; m++) {
			boolean isOrdered = true;
			mpC ++;
			for (int n = 1; n < testa.length - m; n++) {
				if (testa[n - 1] > testa[n]) {
					isOrdered = false;
					tmp = testa[n];
					testa[n] = testa[n - 1];
					testa[n - 1] = tmp;
				}
			}
			if (isOrdered) {
				break;
			}
		}

		System.out.println(Arrays.toString(testa));
		System.out.println("mpC: " + mpC);
	}

}
