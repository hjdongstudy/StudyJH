package com.hjdong.base.classstudy;

public class TestI1 implements I1 {
	public static void main(String[] args) {
		TestI1 t1 = new TestI1();
		t1.test();
	}

	@Override
	public void test1() {
		// TODO Auto-generated method stub
		
	}
}

interface I1 {
	
	static final int ii = 10;
	int i = 10;
	public default void test() {
		System.out.println(i);
	}
	abstract void test1();
}
