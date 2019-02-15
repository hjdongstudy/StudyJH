package com.hjdong.dsc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrieTreeNode implements Comparable<TrieTreeNode>{
    char c;
    
    List<TrieTreeNode> childs = new ArrayList<>();
    
    public TrieTreeNode(char ic) {
        c = ic;
    }
    public char getC() {
        return c;
    }
    public void setC(char c) {
        this.c = c;
    }
    public List<TrieTreeNode> getChilds() {
        return childs;
    }
    public void setChilds(List<TrieTreeNode> childs) {
        this.childs = childs;
    }
    
    @Override
    public String toString() {
        return String.format("data:%s childs:%s", c, childs);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TrieTreeNode)) {
            return false;
        }
        return c == ((TrieTreeNode)obj).getC();
    }
    
    @Override
    public int compareTo(TrieTreeNode o) {
        return c - o.getC();
    }
    
    
    public static void main(String[] args) {
        List<TrieTreeNode> tmp = new ArrayList<>();
        tmp.add(new TrieTreeNode('h'));
        tmp.add(new TrieTreeNode('o'));
        tmp.add(new TrieTreeNode('e'));
    }
    
}
