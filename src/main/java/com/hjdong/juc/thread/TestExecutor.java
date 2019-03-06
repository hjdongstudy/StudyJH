package com.hjdong.juc.thread;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es1 = Executors.newFixedThreadPool(4);
		ExecutorService es2 = Executors.newCachedThreadPool();
		
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(4, 8, 20000, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));
		
	}

}
