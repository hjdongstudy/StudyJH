package com.hjdong.dsc.linklist;

public class LLUtils {

	public static void main(String[] args) {
		Node ll0 = initll(0);
		insertLast(ll0, new Node("newn"));
		printAll(ll0);
		removeLast(ll0);
		printAll(ll0);
		
		
		Node ll1 = initll(1);
		insertLast(ll1, new Node("newn"));
		printAll(ll1);
		removeLast(ll1);
		printAll(ll1);
		
		
		Node ll5 = initll(5);
		insertLast(ll5, new Node("newn"));
		printAll(ll5);
		removeLast(ll5);
		printAll(ll5);
	}
	
	
	public static Node initll(int size) {
		Node head = new Node("head");
		head.setNext(null);
		int i =0;
		while (i < size) {
			insertLast(head, new Node(String.valueOf(i)));
			i ++;
		}
		LLUtils.printAll(head);
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
	
	/**
	 * 在链表最后插入新元素
	 * @param head
	 * @param n
	 */
	public static void removeLast(Node head) {
		Node last = head;
		Node pre = head;
		while (null != last.next) {
			pre = last;
			last = last.next;
		}
		
		pre.next = null;
	}

	
	public static void printAll(Node head) {
		Node p = head;
		while(null != p) {
			System.out.print(p);
			System.out.print(",");
			p = p.next;
		}
		System.out.println();
	}
	
	public static Node initCircleHead() {
//		Node head = new Node("head");
//		Node n0 = new Node("0");
//		Node n1 = new Node("1");
//		Node n2 = new Node("2");
//		Node n30 = new Node("30");
//		Node n31 = new Node("31");
//		Node n32 = new Node("32");
//		Node n33 = new Node("33");
////		Node n34 = new Node("34");
//		
//		head.setNext(n0);
//		n0.setNext(n1);
//		n1.setNext(n2);
//		n2.setNext(n30);
//		n30.setNext(n31);
//		n31.setNext(n32);
//		n32.setNext(n33);
//		n33.setNext(n30);
////		n34.setNext(n30);
		
		
		Node head = new Node("head");
		Node n30 = new Node("30");
		Node n31 = new Node("31");
		Node n32 = new Node("32");
		Node n33 = new Node("33");
		
		head.setNext(n30);
		n30.setNext(n31);
		n31.setNext(n32);
		n32.setNext(n33);
		n33.setNext(n30);
		return head;
	}
}
