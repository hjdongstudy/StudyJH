package com.hjdong.dsc.backtrack;

public class TestBag {

	private static int curMaxW = 0;
	
	public static void main(String[] args) {
		int[] allbag = new int[]{10,23,44,12,15,17,35,31,58,31,1,3,5,78,9};
		
		f(0, 0, allbag, 10, 100);
		
		
//		int w = 100;
//
//		for (int i = 0; i < allbag.length; i ++) {//从i开始找不大于maxW的组合，至往后找
//			int[] haveUseBag = new int[allbag.length];
//			haveUseBag[i] = 1;
//			findBags(allbag, i, allbag[i], w, haveUseBag);
//		}
	}

	/**
	 * 自己的这个做法类似是全排列！TODO
	 * @param allbag
	 * @param i
	 * @param curw
	 * @param w
	 * @param haveUseBag
	 */
	private static void findBags(int[] allbag, int i, int curw, int w, int[] haveUseBag) {
		if (curw < w || i == allbag.length) {
			printUsedBag(allbag, haveUseBag, curw);
		} else {
			return;
		}
		
		for (int j = i + 1; j < allbag.length; j ++) {
			haveUseBag[j] = 1;
			findBags(allbag, j, curw + allbag[j], w, haveUseBag);
		}
		
	}

	private static void printUsedBag(int[] allbag, int[] haveUseBag, int curw) {
		int w = 0;
		StringBuilder sb = new StringBuilder("[Find] ");
		for (int i = 0; i < haveUseBag.length; i++) {
			if (1 == haveUseBag[i]) {
				sb.append(i).append(":").append(allbag[i]).append(",");
				w = w + allbag[i];
			}
		}
		sb.append("total:").append(w);
		System.out.println(sb.toString());
	}



	public static int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值
	// cw 表示当前已经装进去的物品的重量和；i 表示考察到哪个物品了；
	// w 背包重量；items 表示每个物品的重量；n 表示物品个数
	// 假设背包可承受重量 100，物品个数 10，物品重量存储在数组 a 中，那可以这样调用函数：
	// f(0, 0, a, 10, 100)
	public static void f(int i, int cw, int[] items, int n, int w) {
		if (cw == w || i == n) { // cw==w 表示装满了 ;i==n 表示已经考察完所有的物品
			if (cw > maxW)
				maxW = cw;
			return;
		}
		f(i + 1, cw, items, n, w);
		if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
			f(i + 1, cw + items[i], items, n, w);
		}
	}
}
