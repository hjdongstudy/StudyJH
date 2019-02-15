package com.hjdong.base.testdefaultIF;

public interface B extends A {

    default void hello() {
        System.out.println("Hello B");
    }

}
