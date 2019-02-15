package com.hjdong.dscjh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMaxYingshe {

    public static void main(String[] args) {
        String[] allW = new String[] {"ABC", "BGCA", "BCAD", "EBHI", "FBCDA", "FDA", "DJAA"};
        List<Character> noPreList = new ArrayList<>(10);
        noPreList.add('A');
        noPreList.add('B');
        noPreList.add('C');
        noPreList.add('D');
        noPreList.add('E');
        noPreList.add('F');
        noPreList.add('G');
        noPreList.add('H');
        noPreList.add('I');
        noPreList.add('J');
        List<WNode> restNode = new ArrayList<TestMaxYingshe.WNode>();// 0-9-->A-J
        List<WNode> noPreNode = new ArrayList<TestMaxYingshe.WNode>();// 0-9-->A-J
        Map<Character, Integer> ctoqz = new HashMap<>();

        for (String s : allW) {
            noPreList.remove(Character.valueOf(s.charAt(0)));
            char tmpc;
            for (int i = 0; i < s.length(); i++) {
                tmpc = s.charAt(i);
                if (ctoqz.containsKey(tmpc)) {
                    ctoqz.put(tmpc, ctoqz.get(tmpc) + (int)Math.pow(10, i));
                } else {
                    ctoqz.put(tmpc, (int)Math.pow(10, i));
                }
            }
        }

        ctoqz.forEach((Character c, Integer qz) -> {
            if(noPreList.contains(c)) {
                noPreNode.add(new WNode(c, qz)); 
            } else {
                restNode.add(new WNode(c, qz));
            }
            
        });
        System.out.println(noPreList);
        Collections.sort(noPreNode);
        System.out.println(noPreNode);
        
        System.out.println("0" + noPreNode.remove(noPreNode.size() - 1));
        restNode.addAll(noPreNode);
        Collections.sort(restNode);
        System.out.println(restNode);

        for (int i = 9; i >=1; i --) {
            System.out.println(restNode.remove(0) + ":" + i); 
        }

    }

    private static class WNode implements Comparable<WNode> {
        char c;
        int qz;

        public WNode(char cc, int quanzhong) {
            c = cc;
            qz = quanzhong;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[WNode] ");
            sb.append(c).append(":").append(qz);
            return sb.toString();
        }

        @Override
        public int hashCode() {
            return c;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof WNode) {
                return ((WNode)obj).c == c;
            } else {
                return false;
            }
        }

        @Override
        public int compareTo(WNode o) {
            return o.qz - qz;
        }

    }
}
