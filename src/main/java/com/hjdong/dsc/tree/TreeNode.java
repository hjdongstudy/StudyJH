package com.hjdong.dsc.tree;

public class TreeNode {

	int data;
	TreeNode l;
	TreeNode r;

	public TreeNode(int d) {
		data = d;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getL() {
		return l;
	}

	public void setL(TreeNode l) {
		this.l = l;
	}

	public TreeNode getR() {
		return r;
	}

	public void setR(TreeNode r) {
		this.r = r;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(data).append(" ");
		sb.append("l:").append(l==null?null:l.getData()).append(" r:").append(r==null?null:r.getData());
		return sb.toString();
	}
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return String.valueOf(data);
//	}

}
