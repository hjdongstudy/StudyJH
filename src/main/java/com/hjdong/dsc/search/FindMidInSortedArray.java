package com.hjdong.dsc.search;

import java.util.Arrays;

public class FindMidInSortedArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] s1 = new int[] {1, 3, 4, 9, 22, 32, 98};
        int[] s2 = new int[] {2, 5, 6};

        findMidByMerge(s1, s2);
        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));
        
        System.out.println(findMedianSortedArrays(s1, s2));
        System.out.println(findMidByBinarySearch(s1, s2));
        
        
    }

    private static int findMidByBinarySearch(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        
        
        int min = 0;
        int max = m;
        int half = (m + n + 1) / 2;
        int ai = 0,bi = 0;
        while(min <= max) {
            ai = (min + max) / 2;
            bi = half - ai;
            if (ai > min && B[bi-1] > A[ai]) {
                min = min + 1;
            } else if (ai < max && A[ai-1] > B[bi]) {
                max = max + 1;
            } else {
//                int maxLeft = 0;
//                if (i == 0) {
//                    maxLeft = B[j - 1];
//                } else if (j == 0) {
//                    maxLeft = A[i - 1];
//                } else {
//                    maxLeft = Math.max(A[i - 1], B[j - 1]);
//                }
//                if ((m + n) % 2 == 1) {
//                    return maxLeft;
//                }
//
//                int minRight = 0;
//                if (i == m) {
//                    minRight = B[j];
//                } else if (j == n) {
//                    minRight = A[i];
//                } else {
//                    minRight = Math.min(B[j], A[i]);
//                }
//
//                return (maxLeft + minRight) / 2.0;
                
                
//                if (ai == 0) {
//                    return A[ai];
//                }
//                if (bi == 0) {
//                    return B[bi];
//                }
//                
//                if ((m+n)%2 == 1) {
//                    return Math.max(A[ai], B[bi]);
//                } else {
//                    return (A[ai]+B[bi])/2;
//                }
            }
        }
        
        return A[ai];

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) { // to ensure m<=n
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = iMin + 1; // i is too small
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = iMax - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    private static void findMidByMerge(int[] s1, int[] s2) {
        int[] s = new int[s1.length + s2.length];
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        while (true) {
            if (s1[i1] < s2[i2]) {
                s[i] = s1[i1];
                i++;
                i1++;
            } else {
                s[i] = s2[i2];
                i++;
                i2++;
            }

            if (i1 == s1.length) {
                while (i2 < s2.length) {
                    s[i] = s2[i2];
                    i++;
                    i2++;
                }
                break;
            }

            if (i2 == s2.length) {
                while (i1 < s1.length) {
                    s[i] = s1[i1];
                    i++;
                    i1++;
                }
                break;
            }
        }

        System.out.println(Arrays.toString(s));
        System.out.println(s[s.length / 2]);
    }

}
