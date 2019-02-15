package com.hjdong.base.testdefaultIF;

public interface A2 {

    default void hello() {
        System.out.println("Hello A");
    }

}

