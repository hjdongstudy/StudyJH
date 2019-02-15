package com.hjdong.thread;

public class TestJoin {

    public static void main(String[] args) {
        
        System.out.println("MainStart:" + System.currentTimeMillis());
        Thread t1 = new Thread(() -> {
            System.out.println("begin" + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("end" + System.currentTimeMillis());
        });
        t1.start();
        
        try {
            t1.join(2);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("MainExec:" + System.currentTimeMillis());
        
        
    }
}
