package com.hjdong.dsc.backtrack;

import java.util.Arrays;

public class Test8Queen {

	public static void main(String[] args) {
		int a[] = new int[8];
		findAllSolution(a, 0);

	}

	private static void findAllSolution(int[] a, int i) {
		if (i == 8) { // 遍历到最后一列，并且找到了解
			printQueens(a);
			return;
		}

		for (int j = 0; j < 8; j++) {
			if (isOK(a, i, j)) {
				a[i] = j;
				findAllSolution(a, i + 1);
			}
		}

	}

	/**
	 * 
	 * @param a 已经找好部分位置的a
	 * @param i 在给第i行找位置
	 * @param j 第i行尝试在j列放元素
	 * @return
	 */
	private static boolean isOK(int[] a, int i, int j) {
		for (int loc = 0; loc < i; loc++) {
			if (a[loc] == j) { // 如果前i列中，j行有元素，则不满足条件
				return false;
			}
			// 还需要判断对角线--右对角线
			for (int ri = i - 1, rj = j + 1, lj = j -1; ri >= 0; ri--, rj++, lj--) {
				if (a[ri] == rj || a[ri] == lj) {
					return false;
				}
			}
		}
		return true;
	}

	private static void printQueens(int[] result) { // 打印出一个二维矩阵
		for (int row = 0; row < 8; ++row) {
			for (int column = 0; column < 8; ++column) {
				if (result[row] == column)
					System.out.print("Q ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
