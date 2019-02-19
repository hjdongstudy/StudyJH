package com.hjdong.dsc.queue;

import java.util.Stack;

public class Test2StackQueue {

    private static Stack<Integer> s1 = new Stack<>();
    private static Stack<Integer> s2 = new Stack<>();
    private static Stack<Integer> out = s2;
    private static Stack<Integer> in = s1;
    
    public static void main(String[] args) {
        offer(1);
        offer(2);
        offer(3);
        offer(4);
        System.out.println(poll());
        System.out.println(poll());
        System.out.println(poll());
        System.out.println(poll());
        System.out.println(poll());
        System.out.println(poll());
        offer(5);
        offer(6);
        System.out.println(poll());
    }

    private static void offer(int i) {
       in.push(i);
    }

    private static Integer poll() {
        if (out.size() > 0) {
            return out.pop();
        } else {
            if (in.size() == 0) {
                return -1;
            } else {
                while (in.size() > 0) {
                    out.push(in.pop());
                }
                return out.pop();
            }
        }
    }
    
}
