package com.hjdong.dscjh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestJishui {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] taijie = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(getJishui(taijie));
    }

    private static int getJishui(int[] taijie) {
        int jishuiNum = 0;
        int max = 0;
        for(int t : taijie) {
            if (t > max) {
                max = t;
            }
        }
        
        int[][] layerTaijie = new int[max][taijie.length];
        for (int i = 0; i < max; i ++) {
            int[] onel = new int[taijie.length];
            for (int j = 0; j < taijie.length; j ++) {
                onel[j] = (taijie[j] - i) > 0? 1: 0;
            }
            layerTaijie[i] = onel;
        }
        System.out.println(Arrays.deepToString(layerTaijie));
        
        for(int[] ltaiji : layerTaijie) {
            int startIndex = -1;
            for (int i = 0; i < ltaiji.length; i ++) {
                if (startIndex == -1 && ltaiji[i] == 1) {
                    startIndex = i;
                } else if (startIndex != -1 && ltaiji[i] == 1){
                    jishuiNum = jishuiNum + i - startIndex -1;
                    startIndex = i;
                } 
            }
        }
        
        
        return jishuiNum;
    }

}
