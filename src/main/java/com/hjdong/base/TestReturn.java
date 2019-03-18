package com.hjdong.base;

public class TestReturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(testreturn());
	}

	private static int testreturn() {
		int x = 1,y = 2;
		try {
			return x+y;
		} finally {
//			x = 2;
			return 4;
		}
	}

}
