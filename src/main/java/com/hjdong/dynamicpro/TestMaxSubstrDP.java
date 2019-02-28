package com.hjdong.dynamicpro;

import java.util.Arrays;

public class TestMaxSubstrDP {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s1 = "abcdefasdef";
        String s2 = "abefas";
       
        int n1 = s1.length();
        int n2 = s2.length();
        
        int[][] dpmatrix = new int[n1][n2];
        for (int i = 0; i < dpmatrix.length; i ++) {
            for (int j = 0; j < dpmatrix[i].length; j ++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i > 0 && j > 0) {
                        dpmatrix[i][j] = 1 + dpmatrix[i-1][j-1];
                    } else {
                        dpmatrix[i][j] = 1; 
                    }
                    
                }
            }
        }
    
        System.out.println(Arrays.toString(dpmatrix));
        
    }  
            

}
