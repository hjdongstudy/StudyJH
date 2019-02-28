package com.hjdong.dsc.strmatch;

public class TestTrieTree {

    public static void main(String[] args) {
        TrieTreeNode tn = new TrieTreeNode('/');
        insertWord(tn, "how");
        insertWord(tn, "hi");
        insertWord(tn, "her");
        insertWord(tn, "hello");
        insertWord(tn, "so");
        insertWord(tn, "see");
        System.out.println(tn);
        
    }

    private static void insertWord(TrieTreeNode tn, String word) {
        for (char c : word.toCharArray()) {
            TrieTreeNode nt = new TrieTreeNode(c);
            int ccNodeIndex = tn.getChilds().indexOf(nt);
            if (-1 == ccNodeIndex) {
                tn.getChilds().add(nt);
                ccNodeIndex = tn.getChilds().size() - 1;
            }
            tn = tn.getChilds().get(ccNodeIndex);
        }
        
    }
    
    
}
