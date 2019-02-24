package com.hjdong.dsc.dp;

import java.util.Arrays;

public class TestBagsDP {

	private static int maxW = Integer.MIN_VALUE; // 结果放到 maxW 中

	private static int[] itemsWithWeight = { 2, 22, 4, 6, 3 }; // 物品重量

	private static int n = 5; // 物品个数

	private static int w = 9; // 背包承受的最大重量

	public static void main(String[] args) {
		testDp1();
		
		System.out.println("maxW: " + knapsack(itemsWithWeight, n, w));
		System.out.println("maxW: " + knapsack2());
	}

	private static void testDp1() {
		int[][] dpStateAll = new int[n][w + 1];
		dpStateAll[0][0] = -1;// 表示0号物品不参与
		if (itemsWithWeight[0] <= w) {
			dpStateAll[0][itemsWithWeight[0]] = 1;// 表示1号物品参与
		}

		for (int row = 1; row < itemsWithWeight.length; row++) {
			for (int col = 0; col <= 9; col++) {
				if (dpStateAll[row - 1][col] != 0) {
					dpStateAll[row][col] = -1;// 不累加元素
					if (col + itemsWithWeight[row] <= w) {
						dpStateAll[row][col + itemsWithWeight[row]] = 1;
					}
				}
			}
		}

		preettyPrintMatrix(dpStateAll);

	}

	public static int knapsack(int[] weight, int n, int w) {
		boolean[][] states = new boolean[n][w + 1]; // 默认值 false
		states[0][0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
		states[0][weight[0]] = true;
		for (int i = 1; i < n; ++i) { // 动态规划状态转移
			for (int j = 0; j <= w; ++j) {// 不把第 i 个物品放入背包
				if (states[i - 1][j] == true)
					states[i][j] = states[i - 1][j];
			}
			for (int j = 0; j <= w - weight[i]; ++j) {// 把第 i 个物品放入背包
				if (states[i - 1][j] == true)
					states[i][j + weight[i]] = true;
			}
		}
		for (int i = w; i >= 0; --i) { // 输出结果
			if (states[n - 1][i] == true)
				return i;
		}

		return 0;

	}

	public static int knapsack2() {
		boolean[] states = new boolean[w + 1]; // 默认值 false
		states[0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
		if (itemsWithWeight[0] <= w) {
			states[itemsWithWeight[0]] = true;
		}

		for (int i = 1; i < n; ++i) { // 动态规划
			for (int j = w - itemsWithWeight[i]; j >= 0; --j) {// 把第 i 个物品放入背包
				if (states[j] == true && j + itemsWithWeight[i] <= w) {
					states[j + itemsWithWeight[i]] = true;
				}
			}
		}

		System.out.println(Arrays.toString(states));

		for (int oi = w; oi >= 0; --oi) { // 输出结果
			if (states[oi] == true)
				return oi;
		}

		return 0;
	}

	private static void preettyPrintMatrix(int[][] dpStateAll) {
		for (int[] line : dpStateAll) {
			System.out.println(Arrays.toString(line));
		}
	}

}
