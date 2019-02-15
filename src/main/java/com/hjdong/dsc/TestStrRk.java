package com.hjdong.dsc;

public class TestStrRk {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String mainstr = "abcacabdc";
        String fstr = "abd";
        
        char[] mainc = mainstr.toCharArray();
        char[] sc = fstr.toCharArray();
       
        int matchIndex = -1;
        int schashcode = gethashcode(sc, 0, sc.length -1);
        for (int i = 0; i + sc.length -1 < mainc.length; i ++) {
            if (gethashcode(mainc, i, i + sc.length -1) == schashcode) {
                boolean match = true;
                for (int sci = 0; sci < sc.length; sci ++) {
                    if (sc[sci] != mainc[i + sci]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    matchIndex = i;
                    break;
                }
            }
        }
        
        System.out.println(matchIndex);
        
    }
    
    static int gethashcode(char[] cz, int start, int stop) {
        int hashcode = 0;
        for (int i = start; i <= stop; i ++) {
            hashcode = hashcode + cz[i];
        }
        return hashcode;
    }

}
