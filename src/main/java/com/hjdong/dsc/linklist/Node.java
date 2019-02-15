package com.hjdong.dsc.linklist;

public class Node implements Cloneable{
	public Node(String d) {
		data = d;
	}

	String data;
	Node next;

	public String getData() {
		return data;
	}
	
	public int getDataInt() {
		return Integer.valueOf(data);
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return data;
//	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
