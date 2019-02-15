package com.hjdong.dsc.search;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [] a = SortUtils.initRandomSortll(50);
//		Arrays.sort(a);
//		int[] a = new int[] {5, 7, 7, 12, 12, 16, 18, 19, 19, 19, 20, 22, 25, 27, 31, 32, 34, 35, 37, 37, 42, 43, 44, 51, 52, 53, 61, 64, 66, 67, 68, 69, 70, 71, 73, 80, 80, 81, 82, 84, 85, 86, 86, 88, 88, 90, 92, 93, 95, 96};
//		System.out.println(Arrays.toString(a));
//		System.out.println(binarySearch(a, 23));
//		System.out.println(binarySearchRecv(a, 0, a.length -1, 23));
		
//		for (int i = 0; i < 100; i ++) {
//			int [] a = SortUtils.initRandomSortll(50);
//			Arrays.sort(a);
//			System.out.println(Arrays.toString(a));
//			System.out.println(binarySearch(a, 23));
//			System.out.println(binarySearchRecv(a, 0, a.length -1, 23));
//		}
		
		int[] a = new int[] {5, 7, 7, 12, 12, 16, 18, 19, 19, 19, 20, 22, 25, 27, 31, 32, 34, 35, 37, 37, 42, 43, 44, 51, 52, 53, 61, 64, 66, 67, 68, 69, 70, 71, 73, 80, 80, 81, 82, 84, 85, 86, 86, 88, 88, 90, 92, 93, 95, 96};
		System.out.println(binarySearchFirst(a, 19));
		System.out.println(binarySearchLast(a, 19));
		System.out.println(binarySearchFirstEB(a, 19));
		System.out.println(binarySearchLastEL(a, 17));
	}
	
	/**
	 * 寻找最后一个小于等于的xx
	 * @param a
	 * @param i
	 * @return
	 */
	private static int binarySearchLastEL(int[] a, int i) {
		int leftIndex = 0;
		int rightIndex = a.length -1;
		int tryindex;
		while(leftIndex <= rightIndex) {
			tryindex = leftIndex + (rightIndex - leftIndex) /2;
			if (i < a[tryindex]) {
				rightIndex = tryindex - 1;
			}
			
			if (i >= a[tryindex]) {
				if(tryindex == a.length || a[tryindex + 1] > i) {
					return tryindex;
				} else {
					leftIndex = tryindex + 1;
				}
			}
		}
		
		return -1;
	}

	/**
	 * 寻找第一个大于等于的元素
	 * @param a
	 * @param i
	 * @return
	 */
	private static int binarySearchFirstEB(int[] a, int i) {
		int leftIndex = 0;
		int rightIndex = a.length -1;
		int tryindex;
		while(leftIndex <= rightIndex) {
			tryindex = leftIndex + (rightIndex - leftIndex) /2;
			if (i <= a[tryindex]) {
				if (tryindex == 0 || a[tryindex - 1] < i) {
					return tryindex;
				} else {
					rightIndex = tryindex - 1;
				}
			}
			
			if (i > a[tryindex]) {
				leftIndex = tryindex + 1;
			}
		}
		
		return -1;
	}

	private static int binarySearchLast(int[] a, int i) {
		int leftIndex = 0;
		int rightIndex = a.length -1;
		int tryindex;
		while(leftIndex <= rightIndex) {
			tryindex = leftIndex + (rightIndex - leftIndex) /2;
			if (i == a[tryindex]) {
				if (tryindex == a.length -1) {
					return tryindex;
				}
				if (i != a[tryindex + 1]) {
					return tryindex;
				} else {//前边还有相同的元素，继续查找
					leftIndex = tryindex + 1;
				}
			}
			if (i < a[tryindex]) {
				rightIndex = tryindex - 1;
			}
			if (i > a[tryindex]) {
				leftIndex = tryindex + 1;
			}
		}
		return -1;
	}
	
	private static int binarySearchFirst(int[] a, int i) {
		int leftIndex = 0;
		int rightIndex = a.length -1;
		int tryindex;
		while(leftIndex <= rightIndex) {
			tryindex = leftIndex + (rightIndex - leftIndex) /2;
			if (i == a[tryindex]) {
				if (tryindex == 0) {
					return tryindex;
				}
				if (i != a[tryindex - 1]) {
					return tryindex;
				} else {//前边还有相同的元素，继续查找
					rightIndex = tryindex -1;
				}
			}
			if (i < a[tryindex]) {
				rightIndex = tryindex - 1;
			}
			if (i > a[tryindex]) {
				leftIndex = tryindex + 1;
			}
		}
		return -1;
	}

	private static int binarySearch(int[] a, int i) {
		int leftIndex = 0;
		int rightIndex = a.length -1;
		int tryindex;
		while(true) {
			if (leftIndex > rightIndex) {
				return -1;
//				if (i == a[leftIndex]) {
//					return leftIndex;
//				} else {
//					return -1;
//				}
			}
			tryindex = leftIndex + (rightIndex - leftIndex) /2;
			if (i == a[tryindex]) {
				return tryindex;
			}
			if (i < a[tryindex]) {
				rightIndex = tryindex - 1;
			}
			if (i > a[tryindex]) {
				leftIndex = tryindex + 1;
			}
		}
	}
	
	
	private static int binarySearchRecv(int[] a, int l, int r, int i) {
		int tryindex = l + (r - l) /2;
		//无法找到的终结条件
		if (l > r) {
			return -1;
		}
		
		if (i == a[tryindex]) {
			return tryindex;
		} else if (i < a[tryindex]) {
			return binarySearchRecv(a, l, tryindex - 1, i);
		} else {
			return binarySearchRecv(a, tryindex + 1, r, i);
		}
	}
}
