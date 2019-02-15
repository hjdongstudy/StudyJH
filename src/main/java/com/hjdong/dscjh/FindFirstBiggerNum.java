package com.hjdong.dscjh;

import java.util.Stack;

public class FindFirstBiggerNum {
    public static void main(String[] arg) {
        int array[]=new int[] {1,5,3,6,4,8,9,10};
        int res[]=findMax(array);
        for(int num:res) {
            System.out.println(num);
        }
 
    }
    public static int[] findMax(int[] array) {
        int len =array.length;
        Stack<Integer> st = new Stack<Integer>();
        int res[]=new int[len];
        int i=0;
        while(i<len) {
            if(st.isEmpty()||array[i]<=array[st.peek()]) {
                st.push(i);
                i++;
            }else {
                res[st.pop()]=array[i];
 
            }
        }
        while(!st.isEmpty()) {
            res[st.pop()]=-1;
        }
        return res;
    }
 
}
