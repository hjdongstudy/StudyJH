package com.hjdong.dsc.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversalUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeUtils.initTree();
		layerTravel(root);
		preOrderTra(root);
	}

	public static void layerTravel(TreeNode node) {
		if (null == node) {
			return;
		}
		int c = 0; int i = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(node);
		while (!q.isEmpty()) {
			TreeNode tn = q.poll();
			if (null != tn) {
				System.out.print(tn.getData());
				System.out.print("\t");
				
				if (c ==0) {
					System.out.println();
					c ++;
				}
				if (i == Math.pow(2, c)) {
					System.out.println();
					c ++;
					i = 0;
				} 
				i ++;
				
				
				if (null != tn.getL()) {
					q.offer(tn.getL());
				}
				if (null != tn.getR()) {
					q.offer(tn.getR());
				}
			}
		}
	}

	public static void preOrderTra(TreeNode node) {
		if (null == node) {
			return;
		}
		
		System.out.println(node);
		
		preOrderTra(node.l);
		preOrderTra(node.r);
	}
	
	public static void midOrderTra(TreeNode node) {
		if (null == node) {
			return;
		}
		
		midOrderTra(node.l);
		System.out.println(node);
		midOrderTra(node.r);
	}

}
