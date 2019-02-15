package com.hjdong.dsc.strmatch;

public class TestStrBM {

    public static void main(String[] args) {
//        bmSearch("abcacabdc", "abd");
//        System.out.printf("findIndex: %d", bmSearch("aaabaaabaaabaaab", "aaaa"));
        
//        System.out.printf("findIndex: %d", bmSearch("aaaaaaaaaaaaaaaa", "baaa"));
        
        System.out.printf("findIndex: %d", bmSearch("abcacabcbcbacabc", "cbacabc"));

//        System.out.printf("findIndex: %d", bmSearch("abcacabcbcbacabc", "babcab"));

        
    }

    private static int bmSearch(String mainstr, String fstr) {
        char[] mainc = mainstr.toCharArray();
        char[] sc = fstr.toCharArray();
        
        int[] suffix = new int[sc.length];
        boolean[] prefix = new boolean[sc.length];
        generateGS(sc, sc.length, suffix, prefix);
        
        boolean match;
        int si,xi;
        int findIndex = -1;
        int mainSearchIndex = 0;
        while(mainSearchIndex + sc.length - 1 < mainc.length) {
            //每次重新匹配开始的时候，初始化每轮的临时变量
            match = true;
            si = -1;//匹配过程中，坏字符对应在模式串中的位置
            xi = -1;//坏字符在模式串中最后边匹配的位置 
            for (int i = sc.length - 1; i >=0; i --) {
                if (sc[i] != mainc[mainSearchIndex + i]) {
                    si = i;
                    xi = findLastWChar(sc, mainc[mainSearchIndex + i]);
                    match = false;
                    break;
                }
            }
            if (match) {
                findIndex = mainSearchIndex;
                break;
            } else {
                //这里需要综合判断好后缀和坏字符的位置决定移动xxx
                int badCharMoveC = si - xi;
                int goodSuffixMoveC = getGoodSuffixMC(si, sc.length, suffix, prefix);
                mainSearchIndex = mainSearchIndex + Math.max(badCharMoveC, goodSuffixMoveC);
            }
        }
        return findIndex;
    }

    private static int getGoodSuffixMC(int si, int length, int[] suffix, boolean[] prefix) {
        if (si == length -1) {//如果坏字符在模式串最后一位，则没有好前缀，直接xx即可
            return 0;
        }
        
        int goodSuffixLen = length - si;
        if (suffix[goodSuffixLen] != -1) {//好后缀在模式串中有相同的，则移动到对应的位置  :j-suffix[k]+1 位（j 表示坏字符对应的模式串中的字符下标）
            return si - suffix[goodSuffixLen] + 1;
        } 
        //这里需要针对好后缀去遍历寻找，而不是只判断本身(为什么从si+2开始？因为好后缀已经不会在模式串中出现，所以xxx，其实从si+1也可以，只是都会返回false而已)
        for (int r = si + 1; r <= length - 1; ++r) {
            if (prefix[length - r] == true) {
                return r;
            }
        }
        return length;
    }

    /**
     * 寻找坏字符在模式串中的位置
     * TODO 使用hash优化查询效率
     * @param sc
     * @param c
     * @return
     */
    private static int findLastWChar(char[] sc, char c) {
        for (int i = sc.length - 1; i >= 0; i --) {
            if (sc[i] == c) {
                return i;
            }
        }
        return -1;
    }
    
    
    // b 表示模式串，m 表示长度，suffix，prefix 数组事先申请好了
    private static void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; ++i) { // 初始化
            suffix[i] = -1;
            prefix[i] = false;
        }

        for (int i = 0; i < m - 1; ++i) { // b[0, i]
            int j = i;
            int k = 0; // 公共后缀子串长度
            while (j >= 0 && b[j] == b[m - 1 - k]) { // 与 b[0, m-1] 求公共后缀子串
                --j;
                ++k;
                suffix[k] = j + 1; // j+1 表示公共后缀子串在 b[0, i] 中的起始下标
            }
            if (j == -1)
                prefix[k] = true; // 如果公共后缀子串也是模式串的前缀子串
        }

    }


}
