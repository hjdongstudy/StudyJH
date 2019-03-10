package com.hjdong.JMM;

public class TestJMM1 {
	
	private static boolean condition = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		
		Thread t1 = new Thread(() -> {
			while(condition) {
				System.out.println("running");
			}
			System.out.println("stop;");
		}); 
		t1.start();
		
		Thread t2 = new Thread(() -> {condition = false;System.out.println("change");}); 
		t2.start();
	}

}
