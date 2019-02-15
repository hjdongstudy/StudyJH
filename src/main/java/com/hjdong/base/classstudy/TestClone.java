package com.hjdong.base.classstudy;

import com.hjdong.dsc.linklist.Node;

public class TestClone {
	public static void main(String[] args) {
		Node c = new Node("cc");
		Node n1 = new Node("clone1");
		n1.setNext(c);
		try {
			Node n2 = (Node) n1.clone();
			
			System.out.println(n1.getNext());
			System.out.println(n2.getNext());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
