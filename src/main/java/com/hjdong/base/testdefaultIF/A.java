package com.hjdong.base.testdefaultIF;

public interface A {

    default void hello() {
        System.out.println("Hello A");
    }

}

