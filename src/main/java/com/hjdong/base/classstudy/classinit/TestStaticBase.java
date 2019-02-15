package com.hjdong.base.classstudy.classinit;

class TestStaticBase {

	static {
		System.out.println("base static block()");
	}
	public TestStaticBase() {
		System.out.println("Base()");
	}
}