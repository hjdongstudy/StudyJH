package com.hjdong.base.hashcode;

public class A2 {
    String s2;
    public A2(String str) {
        s2 = str;
    }
    
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() - 1;
    }
}
