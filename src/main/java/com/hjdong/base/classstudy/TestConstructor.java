package com.hjdong.base.classstudy;

public class TestConstructor extends SuperCons{

	public TestConstructor() {
		System.out.println("construct method");
	}
	
	public void TestConstructor() {
		System.out.println("ordinary method");
	}
	
	public static void main(String[] args) {
		TestConstructor t1 = new TestConstructor();
		t1.TestConstructor();
	}
}


class SuperCons {
	public SuperCons() {
		System.out.println("super");
	}
}