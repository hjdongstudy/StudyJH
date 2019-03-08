package com.hjdong.dsc.queue;

import java.util.concurrent.PriorityBlockingQueue;

public class TestPriority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityBlockingQueue<Integer> eventCount = new PriorityBlockingQueue<Integer>(10);
		
		eventCount.add(12);
		eventCount.add(1);
		eventCount.add(132);
		eventCount.add(545);
		eventCount.add(5);
		System.out.println(eventCount);
		System.out.println(eventCount.poll());
	}

}
