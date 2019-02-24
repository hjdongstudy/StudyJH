package com.hjdong.dsc.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

	
	public static TreeNode delNode(TreeNode root, TreeNode anode) {
		if (null == root) {
			return null;
		}
		
		TreeNode n = root;
		TreeNode pre = null;
		int ni = -1;//0:l,1:r
		while (n != null) {
			if (anode.getData() == n.getData()) {
				if (n.getL() != null && n.getR() != null) {
					TreeNode minp = n.getR();
					TreeNode minpp = n;
					boolean isf = true;
					while(minp.getL() != null) {
						minpp = minp;
						minp = minp.getL();
						isf = false;
					}
					n.setData(minp.getData());
					n = minp;
					if (isf) {
						minpp.setR(null);
					} else {
						minpp.setL(null);
					}
					
				} else if (n.getL() == null && n.getR() != null) {
					n.setData(n.getR().getData());
					n.setR(null);
					
//					if (0 == ni) {
//						pre.setL(n.getR());
//					} else {
//						pre.setR(n.getR());
//					}
				} else if (n.getL() != null && n.getR() == null) {
					n.setData(n.getL().getData());
					n.setL(null);
					
//					if (0 == ni) {
//						pre.setL(n.getL());
//					} else {
//						pre.setR(n.getL());
//					}
				} else {
					if (0 == ni) {
						pre.setL(null);
					} else {
						pre.setR(null);
					}
				}
				return n;
			}
			if (anode.getData() < n.getData()) {
				pre = n;
				n = n.getL();
				ni = 0;
			}
			if (anode.getData() > n.getData()) {
				pre = n;
				n = n.getR();
				ni = 1;
			}
		}
		
		return null;
	}
	
	public static List<TreeNode> findNodeAll(TreeNode root, TreeNode anode) {
		List<TreeNode> lstFindNodes = new ArrayList<>();
		TreeNode n = root;
		while (n != null) {
			if (anode.getData() == n.getData()) {
				lstFindNodes.add(n);//找到第一个节点--》继续右子树寻找
				n = n.getR();
				continue;
			}
			if (anode.getData() < n.getData()) {
				n = n.getL();
			}
			if (anode.getData() > n.getData()) {
				n = n.getR();
			}
		}
		
		return lstFindNodes;
	}
	
	public static TreeNode findNodeFirst(TreeNode root, TreeNode anode) {
		if (null == root) {
			return null;
		}
		
		TreeNode n = root;
		while (n != null) {
			if (anode.getData() == n.getData()) {
				return n;
			}
			if (anode.getData() < n.getData()) {
				n = n.getL();
			}
			if (anode.getData() > n.getData()) {
				n = n.getR();
			}
		}
		
		return null;
	}
	
	public static void insertNode(TreeNode root, TreeNode anode) {
		if (null == root) {
			return;
		}
		
		TreeNode n = root;
		while (true) {
			if (anode.getData() == n.getData()) {
				if (n.getR() == null) {
					n.setR(anode);
				} else {
					n = n.getR();//继续遍历右子树，找到合适的节点插入
				}
				break;
			}
			if (anode.getData() < n.getData()) {
				if (n.getL() == null) {
					n.setL(anode);
					break;
				}
				n = n.getL();
			}
			if (anode.getData() > n.getData()) {
				if (n.getR() == null) {
					n.setR(anode);
					break;
				}
				n = n.getR();
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(50);
		BinarySearchTree.insertNode(root, new TreeNode(20));
		BinarySearchTree.insertNode(root, new TreeNode(76));
		BinarySearchTree.insertNode(root, new TreeNode(44));
		BinarySearchTree.insertNode(root, new TreeNode(17));
		BinarySearchTree.insertNode(root, new TreeNode(54));
		BinarySearchTree.insertNode(root, new TreeNode(66));
		BinarySearchTree.insertNode(root, new TreeNode(77));
		BinarySearchTree.insertNode(root, new TreeNode(23));
		BinarySearchTree.insertNode(root, new TreeNode(41));
		BinarySearchTree.insertNode(root, new TreeNode(44));
		TreeTraversalUtils.preOrderTra(root);
		System.out.println("----------------------------------");
		System.out.println(findNodeFirst(root, new TreeNode(44)));
		System.out.println(findNodeAll(root, new TreeNode(44)));
		System.out.println("----------------------------------");
		delNode(root, new TreeNode(44));
		TreeTraversalUtils.preOrderTra(root);
		
		
		System.out.println("----------------------------------");
		System.out.println(findminCommonNode(root, 41, 76));
		System.out.println(findminCommonNode(root, 17, 41));
		System.out.println(findminCommonNode(root, 23, 41));
	}

	private static TreeNode findminCommonNode(TreeNode root, int i, int j) {
		if (root.getData() >= i && root.getData() <= j) {
			if (root.getData() == i || root.getData() == j) {//剪枝提前结束
				return root;
			}
		}
		
		//如果都比root小，则在左子树尝试继续寻找
		if (root.getData() >= i && root.getData() >= j && null != root.getL()) {
			return findminCommonNode(root.getL(), i, j);
		}
		
		if (root.getData() <= i && root.getData() <= j && null != root.getR()) {
			return findminCommonNode(root.getR(), i, j);
		}
		
		//如果没有提前结束，则继续在上边的左子树或者右子树遍历，这样就可以找到最小公共根了
		return root;
	}
}
