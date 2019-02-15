package com.hjdong.dsc.sort;

import java.util.Arrays;

public class TestLogNSort {

	public static void main(String[] args) {
//		testGB();
		
		quickSortDemo();
	}

	private static void quickSortDemo() {
		int a[] = SortUtils.initRandomSortll(10);
		System.out.println(Arrays.toString(a));
		qSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
		
	}

	private static void qSort(int[] a, int i, int j) {
		if (i >=j) {
			return;
		}
		
		int mid = partion(a, i, j);
		qSort(a, i, mid -1);
		qSort(a, mid + 1, j);
		return;
	}

	private static int partion(int[] a, int i, int j) {
		int pivot = j;
		int pivotVal = a[j];
		int start = i;
		int end = j;
		while (start < end) {
			while(start < end && a[start] <= pivotVal) {
				start ++;
			}
			if (a[start] > pivotVal) {
				a[pivot] = a[start];
				a[start] = pivotVal;
				pivot = start;
			}
			
			while(start < end && a[end] >= pivotVal) {
				end --;
			}
			if (a[end] < pivotVal) {
				a[pivot] = a[end];
				a[end] = pivotVal;
				pivot = end;
			}
		}
		
		return pivot;
	}

	private static void testGB() {
		// TODO Auto-generated method stub
		int a[] = SortUtils.initRandomSortll(10);
		System.out.println(Arrays.toString(a));
		int m[] = mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(m));
	}

	private static int[] mergeSort(int[] a, int i, int j) {
		if (i >=j) {
			return new int[] {a[i]};
		}
		
		int mid = (j - i)/2 + i;
//		System.out.println(i + " " + j + " " + mid);
		int[] left = mergeSort(a, i, mid);
		int[] right = mergeSort(a, mid + 1, j);
		return merge(left,right);
	}

	private static int[] merge(int[] left, int[] right) {
		int i=0,j=0; 
		int[] m = new int[left.length + right.length];
		int mindex = 0;
		while(i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				m[mindex] = left[i];
				i ++;
			} else {
				m[mindex] = right[j];
				j ++;
			}
			mindex ++;
		}
		if (i == left.length) {
			while(j < right.length) {
				m[mindex] = right[j];
				j ++;
				mindex ++;
			}
		} else {
			while(i < left.length) {
				m[mindex] = left[i];
				i ++;
				mindex ++;
			}
		}
		
		return m;
	}
	
	

	
}
