package com.hjdong.base.testdefaultIF;

public class C implements A, B {

    public static void main(String[] args) {
        new C().hello(); // 输出 Hello B???
    }

}

