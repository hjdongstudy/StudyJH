package com.hjdong.dsc.heap;

import java.util.Arrays;

public class MinHeap {
	// �ѵĴ洢�ṹ - ���� ��0��ʼ�洢
	private int[] data;

	// ��һ�����鴫�빹�췽������ת����һ��С����
	public MinHeap(int[] data) {
		this.data = data;
		buildHeap();
	}

	// ������ת������С��
	private void buildHeap() {
		/**
		 * �ڵ����
		 * ������±��0��ʼ�洢������Ϊi�Ľ�����Ҫ��ϵΪ��
			˫�ף���ȡ�� ��(i-1)/2��
			���ӣ�2i+1
			�Һ��ӣ�2i+2 
			Ҷ�ӽڵ�������n0����n��1��/2
			��������Ϳ����ƶϳ�����һ����Ҷ�ӽڵ��index���ڵ�������0��Ԫ�ؿ�ʼ��������
			n-1 - (n+1)/2  = (2n-2-n-1)/2 = (n-1)/2 -1 
		 */
		
		// ��ȫ������ֻ�������±�С�ڻ���� (data.length) / 2 - 1 ��Ԫ���к��ӽ�㣬������Щ��㡣
		// *���������ͼ�У�������10��Ԫ�أ� (data.length) / 2 - 1��ֵΪ4��a[4]�к��ӽ�㣬��a[5]û��*
		for (int i = (data.length -1) / 2 - 1; i >= 0; i--) {
			// ���к��ӽ���Ԫ��heapify
			heapify(i);
		}
	}

	private void heapify(int i) {
		// ��ȡ���ҽ��������±�
		int l = left(i);
		int r = right(i);

		// ����һ����ʱ��������ʾ ����㡢���㡢�ҽ������С��ֵ�Ľ����±�
		int smallest = i;

		// �������㣬�������ֵС�ڸ�����ֵ
		if (l < data.length && data[l] < data[i])
			smallest = l;

		// �����ҽ�㣬���ҽ���ֵС�����ϱȽϵĽ�Сֵ
		if (r < data.length && data[r] < data[smallest])
			smallest = r;

		// ���ҽ���ֵ�����ڸ��ڵ㣬ֱ��return�������κβ���
		if (i == smallest)
			return;

		// �������ڵ�����ҽ������С���Ǹ�ֵ���Ѹ��ڵ��ֵ�滻��ȥ
		swap(i, smallest);

		// �����滻�����������ᱻӰ�죬����Ҫ����Ӱ��������ٽ���heapify
		heapify(smallest);
	}

	// ��ȡ�ҽ��������±�
	private int right(int i) {
		return (i + 1) << 1;
	}

	// ��ȡ����������±�
	private int left(int i) {
		return ((i + 1) << 1) - 1;
	}

	// ����Ԫ��λ��
	private void swap(int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	// ��ȡ���е���С��Ԫ�أ���Ԫ��
	public int getRoot() {
		return data[0];
	}

	// �滻��Ԫ�أ�������heapify
	public void setRoot(int root) {
		data[0] = root;
		heapify(0);
	}
	
	@Override
	public String toString() {
		return Arrays.toString(data);
	}
	
	public static void main(String[] args) {
		int[] data = new int[] {10,3,9,8,34,23,12,56,12,33};
		System.out.println(Arrays.toString(data));
		MinHeap mh = new MinHeap(data);
		System.out.println(mh);
	}
}
