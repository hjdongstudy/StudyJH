package com.hjdong.test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Test {
    
    public static final int si = 0;

    public static void main(String[] args) throws UnsupportedEncodingException {
        String testcompactstr1 = "compact";
        String testcompactstr2 = "compact中文";
        
        System.out.println(testcompactstr1.length());
        System.out.println(testcompactstr2.length());
        
        int i = 1;
        System.out.println(i+++i++);
        System.out.println(i+++(++i));
        
        
        System.out.println("hjdong".getBytes("gbk").length);
        System.out.println("中文".getBytes("gbk").length);
        System.out.println("hjdong".getBytes("utf-8").length);
        System.out.println("中文".getBytes("utf-8").length);
        
        short s1 = 123;
        short s2 = -123;
        int i2 = -123;
        System.out.println(Short.toUnsignedInt((short)-123));
        System.out.println(Integer.toBinaryString(s1));
        s1>>=33;
        System.out.println(Integer.toBinaryString(s1));
        System.out.println(Integer.toBinaryString(s2));
        System.out.println(Integer.toBinaryString(i2));
        s2>>=1;
        System.out.println(Integer.toBinaryString(s2));
        
        System.out.println(Charset.defaultCharset());
        
    }
}
