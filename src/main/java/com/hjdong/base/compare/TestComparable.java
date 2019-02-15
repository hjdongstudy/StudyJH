package com.hjdong.base.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparable {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer> l = new ArrayList<>();
        l.add(10);
        l.add(1);
        l.add(11);
        l.add(3);
        Collections.sort(l, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;//从大到小
//                return o1 - o2;//从小到大
            }});
        System.out.println(l);
        
        
        
        List<A> al = new ArrayList<>();
        al.add(new A(10));
        al.add(new A(1));
        al.add(new A(11));
        al.add(new A(3));
        Collections.sort(al);
        System.out.println(al);
    }

}
