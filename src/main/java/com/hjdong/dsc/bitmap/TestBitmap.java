package com.hjdong.dsc.bitmap;

import java.util.BitSet;

public class TestBitmap {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 22, 0, 3, 63};
        BitSet bitSet = new BitSet(1);
        System.out.println(bitSet.size()); // 64
        bitSet = new BitSet(65);
        System.out.println(bitSet.size()); // 128
        bitSet = new BitSet(23);
        System.out.println(bitSet.size()); // 64

        // 将数组内容组bitmap
        for (int i = 0; i < array.length; i++) {
            bitSet.set(array[i], true);
        }

        System.out.println(bitSet.get(22));
        System.out.println(bitSet.get(60));

        System.out.println("下面开始遍历BitSet：");
        for (int i = 0; i < bitSet.size(); i++) {
            System.out.println(bitSet.get(i));
        }
        

        //如何存储
        bitSet.toByteArray();
        BitSet.valueOf(new byte[] {1,2,3,4});
    }

}
