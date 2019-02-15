package com.hjdong.base.testdefaultIF;

public class C2 implements A,A2{
	
	public static void main(String[] args) {
		 new C2().hello();
	}

	@Override
	public void hello() {
		// TODO Auto-generated method stub
		A.super.hello();
	}

}
