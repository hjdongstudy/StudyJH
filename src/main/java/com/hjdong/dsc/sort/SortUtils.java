package com.hjdong.dsc.sort;

import java.util.Random;

public class SortUtils {

	public static int[] initRandomSortll(int size) {
		int[] testa = new int[size];
		Random r = new Random();
		for (int i = 0; i < size; i ++) {
			testa[i] = r.nextInt(100);
		}
		return testa;
	}
}
