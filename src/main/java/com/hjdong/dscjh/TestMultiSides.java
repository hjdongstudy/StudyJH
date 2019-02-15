package com.hjdong.dscjh;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入描述: 每组测试用例仅包含一组数据，每组数据第一行为一个正整数 n 表示操作的数量(1 ≤ n ≤ 50000) ， 接下来有n行，每行第一个整数为操作类型 i (i ∈ {1,2})，第二个整数为一个长度 L(1 ≤ L ≤
 * 1,000,000,000)。如果 i=1 代表在集合内插入一个长度为 L 的木棒，如果 i=2 代表删去在集合内的一根长度为 L 的木棒。输入数据保证删除时集合中必定存在长度为 L 的木棒，且任意操作后集合都是非空的。 输出描述:
 * 对于每一次操作结束有一次输出，如果集合内的木棒可以构成简单多边形，输出 "Yes" ，否则输出 "No"。
 * 
 * @author hjdong
 *
 */
public class TestMultiSides {

    public static void main(String[] args) throws FileNotFoundException {
        PriorityQueue<Integer> allSides = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        BufferedReader br = new BufferedReader(new FileReader("data/TestMultiSidesData.txt"));;
        try (br) {
            int opNum = Integer.valueOf(br.readLine());
            String inputLine = br.readLine();
            String[] lAndOp;
            int sideLength;
            int op;
            while (null != inputLine) {
                lAndOp = inputLine.split(" ");
                op = Integer.valueOf(lAndOp[0]);// 1添加，2删除
                sideLength = Integer.valueOf(lAndOp[1]);// 木棒长度
                if (1 == op) {
                    allSides.add(sideLength);
                } else {
                    allSides.remove(sideLength);
                }
                System.out.println(allSides);
                
                System.out.println(judgeCanMake(allSides));
                
                
                inputLine = br.readLine();
            }
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static boolean judgeCanMake(PriorityQueue<Integer> allSides) {
//        int[] sideArry = new int[allSides.size()];
        if (allSides.size() < 3) {
            return false;
        }
        Object[] sideArry = allSides.toArray();
        int sumOther = 0;
        int maxLen = 0;
        for (int i = 0; i < sideArry.length; i ++) {
            if (i == 0) {
                maxLen = (int)sideArry[i];
            } else {
                sumOther = sumOther + (int)sideArry[i];
            }
        }
        
        if (sumOther > maxLen) {
            return true;
        } else {
            return false;
        }
    }

}
