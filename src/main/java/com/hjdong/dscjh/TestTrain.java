package com.hjdong.dscjh;

import java.util.Arrays;

public class TestTrain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] trainticket = new int[6][6];
		trainticket[0] = new int[]{-1,99,99,99,99,99};
		trainticket[1] = new int[]{99,-1,99,99,99,99};
		trainticket[2] = new int[]{99,99,-1,99,99,99};
		trainticket[3] = new int[]{99,99,99,-1,99,99};
		trainticket[4] = new int[]{99,99,99,99,-1,99};
		trainticket[5] = new int[]{99,99,99,99,99,-1};
		
		
		sale(trainticket, 1,4);
		print(trainticket);
	}

	private static void print(int[][] trainticket) {
		for (int[] tt : trainticket) {
			System.out.println(Arrays.toString(tt));
		}
		
	}

	private synchronized static void sale(int[][] trainticket, int s, int e) {
		int colS = 0;
		for (int i = 0; i < e; i ++) {
			if (i > s + 1) {
				colS = i;
			} else {
				colS = s + 1;
			}
			for (int j = colS; j < trainticket[i].length; j ++) {
				trainticket[i][j] = trainticket[i][j] - 1;
			}
		}
	}

}
