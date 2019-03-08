package com.hjdong.dscjh;

public class FindMaxInTuofengArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = new int[] {2, 3, 4, 7, 8, 5, 3};
        System.out.println(findMax(a));
    }

    private static int findMax(int[] a) {
        int l = 0; int r = a.length -1;
        int mid = 0;
        while(l < r) {
            mid = l + (r - l)/2;
            if (mid +1 < a.length && a[mid+1] > a[mid]) {
                l = mid + 1;
            } else if (mid - 1 >= 0 && a[mid-1] > a[mid]) {
                r = mid -1;
            } else {
                return a[mid]; 
            }
        }
        return a[l];
    }

}
