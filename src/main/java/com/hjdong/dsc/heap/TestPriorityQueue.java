package com.hjdong.dsc.heap;

import java.util.PriorityQueue;

public class TestPriorityQueue {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(50);
        pq.add(4);
        pq.add(12);
        pq.add(45);
        pq.add(96);
        pq.add(23);
        pq.add(74);
        System.out.println(pq);
        pq.remove();
        System.out.println(pq);
        
    }

}
