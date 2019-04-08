package com.hjdong.dsc.sort;

import java.util.Arrays;

public class FindKMax {

	public static void main(String[] args) {
		int k = 4;
		FindKMax fkm = new FindKMax();
		int a[] = SortUtils.initRandomSortll(10);
		System.out.println(Arrays.toString(a));
		int start = 0;
		int end = a.length - 1;
		int nindex = getPartionIndex(a, start, end);
		while (nindex != k -1) {
			if (nindex > k -1) {
				nindex = getPartionIndex(a, start, nindex - 1);
			} else {
				nindex = getPartionIndex(a, nindex + 1, end);
			}
		} 
		System.out.println(a[nindex]);
	}

	private static int getPartionIndex(int[] a, int i, int j) {
		int privot = j;
		int privotval = a[j];

		while (i < j) {
			while (a[i] <= privotval && i < j) {
				i ++;
			}
			a[privot] = a[i];
			a[i] = privotval;
			privot = i;
			
			while (a[j] > privotval && i < j) {
				j --;
			}
			a[privot] = a[j];
			a[j] = privotval;
			privot = j;
		}
		
		return privot;
	}


}
