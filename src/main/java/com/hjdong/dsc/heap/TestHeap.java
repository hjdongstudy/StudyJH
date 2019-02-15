package com.hjdong.dsc.heap;

import java.util.Arrays;
import java.util.Random;

public class TestHeap {

	private static final Random r = new Random();

	public static void main(String[] args) {
//		int[] test = new int[10];
//		System.out.println(test.length);

		int[] a = initHeap(20);
		System.out.println(Arrays.toString(a));
		a = initMaxTopHeap(a);
		System.out.println(Arrays.toString(a));
		
		int[] newa = new int[30];
		int numOfNode = 0;
		for (; numOfNode < 20; numOfNode ++) {
			insertToMaxHeap(newa, numOfNode, r.nextInt(30) + 1);
			System.out.println(Arrays.toString(newa));
		}
		
		System.out.println("---------------------");
		numOfNode = removeTopOfHeap(newa, numOfNode);
		System.out.println(Arrays.toString(newa));
		numOfNode = removeTopOfHeap(newa, numOfNode);
		System.out.println(Arrays.toString(newa));
		numOfNode = removeTopOfHeap(newa, numOfNode);
		System.out.println(Arrays.toString(newa));
		numOfNode = removeTopOfHeap(newa, numOfNode);
		System.out.println(Arrays.toString(newa));
	}


	private static int removeTopOfHeap(int[] a, int numOfNode) {
		if (numOfNode == 0 || numOfNode == 1) {
			return 0;
		}
		
		a[0] = a[numOfNode -1];
		a[numOfNode] = 0;
		swapHeapREV(a, 0, numOfNode);
		return --numOfNode;
	}


	/**
	 * @param a
	 * @return
	 */
	private static void insertToMaxHeap(int[] a, int nodec, int insertNode) {
		if (nodec == 0) {
			a[0] = insertNode;
			return;
		}
		
		int tmp;
		int childIndex = nodec;
		a[childIndex] = insertNode;
		int parIndex = (childIndex -1) / 2;
		while (parIndex >= 0) {
			if (a[parIndex] < a[childIndex]) {
				tmp = a[childIndex];
				a[childIndex] = a[parIndex];
				a[parIndex] = tmp;
				if (parIndex > 0) {
					childIndex = parIndex;
					parIndex = (childIndex -1) / 2;
				} else {
					break;
				}
			} else {
				break;
			}
		}
	}
	
	/**
	 * @param a
	 * @return
	 */
	private static int[] initMaxTopHeap(int[] a) {
		for (int i = (a.length - 1) / 2 - 1; i >= 0; i--) {
			swapHeap(a, i);
		}
		return a;
	}

	/**
	 * 从上往下初始化堆---如果是从最后一个非叶子节点往上的话，由于这些非叶子节点已经是最大的，所以是不需要迭代的
	 * @param a
	 * @param parIndex
	 */
	private static void swapHeap(int[] a, int parIndex) {
		int max = a[parIndex], maxIndex = parIndex;
		int lcIndex = 2 * parIndex + 1;
		int rcIndex = 2 * parIndex + 2;
		if (lcIndex < a.length && a[lcIndex] > max) {
			max = a[lcIndex];
			maxIndex = lcIndex;
		}

		if (rcIndex < a.length && a[rcIndex] > max) {
			max = a[rcIndex];
			maxIndex = rcIndex;
		}
		if (parIndex != maxIndex) {
			a[maxIndex] = a[parIndex];
			a[parIndex] = max;
			parIndex = maxIndex;
		}
	}
	
	
	/**
	 * 从上往下
	 * @param a
	 * @param parIndex
	 */
	private static void swapHeapREV(int[] a, int parIndex, int numOfNodes) {
		int max = a[parIndex], maxIndex = parIndex;
		int lcIndex = 2 * parIndex + 1;
		int rcIndex = 2 * parIndex + 2;
		while (true) {
			if (lcIndex < a.length && a[lcIndex] > max) {
				max = a[lcIndex];
				maxIndex = lcIndex;
			}

			if (rcIndex < a.length && a[rcIndex] > max) {
				max = a[rcIndex];
				maxIndex = rcIndex;
			}
			
			if (parIndex != maxIndex) {
				a[maxIndex] = a[parIndex];
				a[parIndex] = max;
				//
				parIndex = maxIndex;
				max = a[parIndex];
				maxIndex = parIndex;
				lcIndex = 2 * parIndex + 1;
				rcIndex = 2 * parIndex + 2;
			} else {//已经是最大了，par比所有子节点大，直接返回
				break;
			}
		}
 		
	}
	
	private static int[] initHeap(int size) {
		return new int[] { 82, 72, 22, 72, 40, 84, 40 };

//		int[] hsz = new int[size];
//		for (int i = 0; i < size; i ++) {
//			hsz[i] = r.nextInt(100);
//		}
//		return hsz;
	}

}
