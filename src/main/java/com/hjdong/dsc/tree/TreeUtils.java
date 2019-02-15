package com.hjdong.dsc.tree;

import java.util.Random;

public class TreeUtils {

	private static Random r = new Random();
	
	/**
	 * 链表形式初始化一个完全二叉树
	 * @param layer
	 * @param bound
	 * @return
	 */
	public static TreeNode initTree() {
		TreeNode root = new TreeNode(2);
		TreeNode t10 = new TreeNode(57);
		TreeNode t11 = new TreeNode(79);
		root.setL(t10);
		root.setR(t11);
		
		TreeNode t100 = new TreeNode(77);
		TreeNode t101 = new TreeNode(32);
		TreeNode t110 = new TreeNode(92);
		TreeNode t111 = new TreeNode(4);
		t10.setL(t100);
		t10.setR(t101);
		t11.setL(t110);
		t11.setR(t111);
		
		TreeNode t1000 = new TreeNode(6);
		TreeNode t1001 = new TreeNode(48);
		TreeNode t1010 = new TreeNode(15);
		TreeNode t1011 = new TreeNode(43);
		TreeNode t1100 = new TreeNode(86);
		t100.setL(t1000);
		t100.setR(t1001);
		t101.setL(t1010);
		t101.setR(t1011);
		t110.setL(t1100);
		return root;
	}
	
	/**
	 * 链表形式初始化一个完全二叉树
	 * @param layer
	 * @param bound
	 * @return
	 */
	public static TreeNode initTreeRandom() {
		TreeNode root = new TreeNode(r.nextInt(100));
		TreeNode t10 = new TreeNode(r.nextInt(100));
		TreeNode t11 = new TreeNode(r.nextInt(100));
		root.setL(t10);
		root.setR(t11);
		
		TreeNode t100 = new TreeNode(r.nextInt(100));
		TreeNode t101 = new TreeNode(r.nextInt(100));
		TreeNode t110 = new TreeNode(r.nextInt(100));
		TreeNode t111 = new TreeNode(r.nextInt(100));
		t10.setL(t100);
		t10.setR(t101);
		t11.setL(t110);
		t11.setR(t111);
		
		TreeNode t1000 = new TreeNode(r.nextInt(100));
		TreeNode t1001 = new TreeNode(r.nextInt(100));
		TreeNode t1010 = new TreeNode(r.nextInt(100));
		TreeNode t1011 = new TreeNode(r.nextInt(100));
		TreeNode t1100 = new TreeNode(r.nextInt(100));
		t100.setL(t1000);
		t100.setR(t1001);
		t101.setL(t1010);
		t101.setR(t1011);
		t110.setL(t1100);
		return root;
	}
}
