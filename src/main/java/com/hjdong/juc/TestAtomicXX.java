package com.hjdong.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicXX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtomicInteger ai1 = new AtomicInteger(123);
		ai1.getAndIncrement();
	}

}
