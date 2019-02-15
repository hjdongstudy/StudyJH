package com.hjdong.base.classstudy.classinit;

public class TestClassInitOrder extends TestStaticBase {
	static {
		System.out.println("Derive static block()");
	}
	
	private Member m1 = new Member("Member 1");
	{
		System.out.println("Initial Block()");
	}

	public TestClassInitOrder() {
		System.out.println("Derive()");
	}

	private Member m2 = new Member("Member 2");
	private int i = getInt();

	private int getInt() {
		System.out.println("getInt()");
		return 2;
	}

}