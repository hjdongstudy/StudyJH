package com.hjdong.dscjh;

import java.util.Arrays;
import java.util.Scanner;

public class TestMagicWeigth {

    private static int num;

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        String[] str = new String[n];
//        for (int i = 0; i < n; i++) {
//            str[i] = in.next();
//        }
//        in.close();

        int n = 3;
        int k = 2;
        String[] str = new String[] {"AB", "RAAB", "RA"};
        
        permmy(str, 0);
//        perm(str, 0, str.length - 1, k);

        // 输出权值为K的字符串个数
        System.out.println(num);
        
        
//      String[] str = new String[] {"1", "2", "3", "4"};
//    zuhe(str);

    }
    
    
    private static void zuhe(String[] str) {
        for (int zuheNum = 1; zuheNum <= str.length; zuheNum ++) {
            for (int startIndex = 0; startIndex < str.length; startIndex ++) {
                StringBuilder tmpsb = new StringBuilder(str[startIndex]);
                int i =1;
                for (int j = 0; j < str.length; j++) {
                    if (i >= zuheNum) {
                        break;
                    }
                    if (j != startIndex) {
                        tmpsb.append(",").append(str[j]);
                        i++;
                    }
                }
                System.out.println(tmpsb.toString());
            }
        }
        
    }

    private static void permmy(String[] str, int startIndex) {
       if (startIndex == str.length -1) {
           System.out.println(Arrays.toString(str));
           return;
       }
       
       for (int i = startIndex; i < str.length; i ++) {
           if (i == startIndex) {
               permmy(str, startIndex + 1);
           } else if (i != startIndex && str[startIndex] != str[i]) {
               swap(str, startIndex, i);
               permmy(str, startIndex + 1);
               swap(str, startIndex, i);
           } 
       }
    }





    public static String[] swap(String[] buf, int a, int b) {
        String temp = buf[a];
        buf[a] = buf[b];
        buf[b] = temp;
        return buf;
    }

    // 求全排列
    public static void perm(String[] buf, int start, int end, int k) {
        if (start == end) {
            String s = "";
            for (int i = 0; i <= end; i++) {
                s += buf[i];
            }
            judge(s, k);
        } else {
            for (int i = start; i <= end; i++) {
                buf = swap(buf, start, i);
                perm(buf, start + 1, end, k);
                buf = swap(buf, start, i);
            }
        }
    }

    // 判断权值
    public static void judge(String S, int k) {
        System.out.println("doJudeg: " + S);
        int count = 0;
        String string = S + S;

        for (int i = 1; i < S.length() + 1; i++) {
            if (S.equals(string.substring(i, i + S.length()))) {
                System.out.println("[HIT] time:" + count + "ori:" + S + " n:" + string);
                count += 1;
            }
        }
        if (count == k) {
            num++;
        }
    }
}
