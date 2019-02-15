package com.hjdong.dscjh;

import java.util.ArrayList;
import java.util.List;

public class TestKSplit {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<TestKSplit.Side> allSide = initSides();
        
        printKSplit(allSide, 5);
    }
    
    
    private static void printKSplit(List<Side> allSide, int k) {
        int kl = getLength(allSide) / k;
        int prel = 0;//累计的边长
        Node kn;
        Node sn = null;//起点
        for (TestKSplit.Side s : allSide) {
            while (true) {
                if (s.getRestLength(sn) >= kl - prel) {
                    kn = findKn(s, sn, prel, kl);
                    System.out.println("(" + kn.getX() + "," + kn.getY() + ")");
                    sn = kn;
                    prel = 0;
                } else {
                    prel = prel + s.getRestLength(sn);
                    sn = s.getEndN();
                    break;
                }
            }
        }
    }


    private static Node findKn(Side s, Node sn, int prel, int kl) {
        Node n = new Node();
        if (null == sn) {
            sn = s.getStartN();
        }
        
        if(s.getStartN().getX() == s.getEndN().getX()) {
            n.setX(s.getStartN().getX());
            if (s.getStartN().getY() < s.getEndN().getY()) {
                n.setY(sn.getY() + kl - prel); 
            } else {
                n.setY(sn.getY() - kl + prel); 
            }
           
        } else {
            if (s.getStartN().getX() < s.getEndN().getX()) {
                n.setX(sn.getX() + kl - prel); 
            } else {
                n.setX(sn.getX() - kl + prel); 
            }
            n.setY(s.getStartN().getY());
        }
        return n;
    }


    private static List<Side> initSides() {
        Side s1 = new Side(new Node(2, 2), new Node(2, 4));
        Side s2 = new Side(new Node(2, 4), new Node(4, 4));
        Side s3 = new Side(new Node(4, 4), new Node(4, 6));
        Side s4 = new Side(new Node(4, 6), new Node(8, 6));
        Side s5 = new Side(new Node(8, 6), new Node(8, 2));
        Side s6 = new Side(new Node(8, 2), new Node(2, 2));
        List<Side> as = new ArrayList<>();
        as.add(s1);
        as.add(s2);
        as.add(s3);
        as.add(s4);
        as.add(s5);
        as.add(s6);
        return as;
    }
    
    private static int getLength(List<TestKSplit.Side> as) {
        int length = 0;
        for (TestKSplit.Side s : as) {
            length = length + s.getLength();  
        }
        //        as.forEach((TestKSplit.Side item) -> {l = Integer.sum(l, item.getLength());});
        return length;
    }


    public static class Node {
        int x;
        int y;
        public Node(int xx, int yy) {
            x = xx;
            y = yy;
        }
        public Node() {
            // TODO Auto-generated constructor stub
        }
        public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }
        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }
    }
    
    public static class Side {
        Node startN;
        Node endN;
        public Side(Node s, Node e) {
            startN = s;
            endN = e;
        }
        
        public Node getStartN() {
            return startN;
        }
        public void setStartN(Node startN) {
            this.startN = startN;
        }
        public Node getEndN() {
            return endN;
        }
        public void setEndN(Node endN) {
            this.endN = endN;
        }
        
        public int getLength() {
            if(startN.getX() == endN.getX()) {
                return Math.abs(startN.getY() - endN.getY());
            }
            
            return Math.abs(startN.getX() - endN.getX());
        }
        
        public int getRestLength(Node sn) {
            if (null == sn) {
                sn = startN;
            }
            
            if(startN.getX() == endN.getX()) {
                return Math.abs(endN.getY() - sn.getY());
            }
            
            return Math.abs(endN.getX() - sn.getX());
        }
    }
    

}
