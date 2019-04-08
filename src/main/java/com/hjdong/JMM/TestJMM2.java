package com.hjdong.JMM;

public class TestJMM2 {

    public static volatile int i = 0;

    public static void main(String[] args) {
        Thread t2 = new Thread(() -> {
            System.out.println("t2 " + i);
        });
        t2.start();
        
        
        Thread t1 = new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
            System.out.println("t1 " + i);
            i = i + 1;
        });
        t1.start();

       
    }

}
