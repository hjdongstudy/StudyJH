package com.hjdong.base;

import java.util.Vector;

public class TestBaseDsc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i11 = new Integer(123);
		Integer i12 = new Integer(123);
		Integer i21 = new Integer(222);
		Integer i22 = new Integer(123);
		System.out.println(i11.equals(i12));
		System.out.println(i21.equals(i22));
		
		// 第一种：直接赋一个字面量
		String str1 = "ABCD";
		String str2 = "EFG";
		// 第二种：通过构造器创建
		String str3 = new String("ABCD");
		System.out.println(str1 == str3);
		
		StringBuilder s1 = new StringBuilder("123");

		long cur = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i ++) {
//			String ssss = str1 + "" + str2;
			s1.append("").append(str2);
			
		}
		System.out.println(System.currentTimeMillis() - cur);
		
		
		Vector<String> v1 = new Vector<>();
		v1.add("asd");
		
		
		
	}

}
