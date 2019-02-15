package com.hjdong.base.compare;

public class A implements Comparable<A>{
    int i;
    
    public A(int ii) {
        i = ii;
    }

    @Override
    public int compareTo(A o) {
        return o.i - i;//从大到小
//        return i - o.i;//从小到大
    }
    
    @Override
    public String toString() {
        return String.valueOf(i);
    }
}
