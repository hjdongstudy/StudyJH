package com.hjdong.cp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestConsumerAndProducer {

	public static final int cap = 10;
	public static final List<String> q = new ArrayList<>(cap);
	static final Random r = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object lock = new Object();

		new Thread(()->{}).start(); 
		
		new Thread(new Runnable() {
			@Override
			public void run() {// 消费者
				while (true) {
					synchronized (lock) {
						if (q.size() == 0) {
							System.out.println("consumer queue empty, wait....");
							try {
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					
					synchronized (lock) {
						try {
							String n = q.remove(q.size() - 1);
							System.out.println("consumer finish" + n + ", wait....");
							lock.notify();
							Thread.currentThread().sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {// 生产者
				while (true) {
					synchronized (lock) {
						if (q.size() == cap) {
							System.out.println("produce queue full, wait....");
							try {
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					
					synchronized (lock) {
						try {
							Thread.currentThread().sleep(1000);
							String n = String.valueOf(System.currentTimeMillis());
							q.add(n);
							System.out.println("produce finish " + n);
							lock.notify();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
	}

}
