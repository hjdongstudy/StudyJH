package com.hjdong.base.classstudy.classinit;

public class TestClassLoader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ClassLoader.getPlatformClassLoader().loadClass("com.hjdong.base.classstudy.classinit.TestClassInitOrder");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
