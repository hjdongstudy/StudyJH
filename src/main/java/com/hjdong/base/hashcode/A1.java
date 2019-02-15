package com.hjdong.base.hashcode;

public class A1 {
    String s1;
    public A1(String str) {
        s1 = str;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof A1)) {
            return false;
        }
        
        return s1 == null? ((A1)obj).s1 == null : s1.equals(((A1)obj).s1);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() +1;
    }
}
