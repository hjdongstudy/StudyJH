package com.hjdong.dsc.linklist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 3) 两个有序的链表合并
 * @author hjdong
 *
 */
public class TestSortLLMerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node h1 = initRandomSortll(15);
		Node h2 = initRandomSortll(23);
		LLUtils.printAll(h1);
		LLUtils.printAll(h2);		
		Node head = mergeSortedLL(h1, h2);
		LLUtils.printAll(head);	}
	
	/**
	 * 合并链表--空间复杂度+时间复杂度均最低
	 * @param h1
	 * @param h2
	 * @return
	 */
	private static Node mergeSortedLL(Node h1, Node h2) {
		Node newHead = new Node("head");
		
		if (h1.next == null) {
			return h2;
		}
		
		if (h2.next == null) {
			return h1;
		}
		
		Node h1cur = h1.next;
		Node h2cur = h2.next;
		Node cur = newHead;
		
		while (true) {
			if (h1cur.getDataInt() < h2cur.getDataInt()) {
				cur.next = h1cur;
				cur = h1cur;
				h1cur = h1cur.next;
				if (h1cur == null) {
					cur.next = h2cur;
					break;
				}
			} else {
				cur.next = h2cur;
				cur = h2cur;
				h2cur = h2cur.next;
				if (h2cur == null) {
					cur.next = h1cur;
					break;
				}
			}
		}
		
		
		return newHead;
	}

	public static Node initRandomSortll(int size) {
		Random r = new Random();
		List<Integer> ll = new ArrayList<>();
		for (int i = 0; i < size; i ++) {
			ll.add(r.nextInt(100));
		}
		Collections.sort(ll);
		
		Node head = new Node("head");
		head.setNext(null);
		for (Integer ii : ll) {
			insertLast(head, new Node(String.valueOf(ii)));
		} 
		return head;
	}
	
	/**
	 * 在链表最后插入新元素
	 * @param head
	 * @param n
	 */
	public static void insertLast(Node head, Node n) {
		Node fast = head;
		while (null != fast.next) {
			fast = fast.next;
		}
		
		fast.next = n;
	}

}
