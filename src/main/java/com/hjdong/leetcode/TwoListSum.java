package com.hjdong.leetcode;

public class TwoListSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoListSum tt = new TwoListSum();
		ListNode l1 = tt.new ListNode(2);
		l1.next = tt.new ListNode(4);
		l1.next.next = tt.new ListNode(3);
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode nh = null;
		ListNode n1 = l1;
		ListNode n2 = l2;
		int shiwei = 0;
		int gewei = 0;
		while (n1 != null && n2 !=null) {
			gewei = (n1.val + n2.val) % 10;
			ListNode nn = new ListNode(gewei + shiwei);
			if (null == nh) {
				head = nn;
				nh = nn;
			} else {
				nh.next = nn;
				nh = nn;
			}
			shiwei = (n1.val + n2.val) / 10;
			n1 = n1.next;
			n2 = n2.next;
		}
		
		
		
		if (n1 == null && n2 != null) {
			if (null == nh) {
				return n2;
			} else {
				nh.next = n2;
				while (n2 !=null) {
					gewei = (n2.val + shiwei) % 10;
					shiwei = (n2.val + shiwei) / 10;
					n2.val = gewei;
					n2 = n2.next;
				}
			}
		} else if (n2 == null & n1 != null) {
			if (null == nh) {
				return n1;
			} else {
				nh.next = n1;
				while (n1 !=null) {
					gewei = (n1.val + shiwei) % 10;
					shiwei = (n1.val + shiwei) / 10;
					n1.val = gewei;
					n1 = n1.next;
				}
			}
		} else {
			if (shiwei != 0) {
				ListNode ln = new ListNode(shiwei);
				nh.next = ln;
			}
		}
 		
		return head;
	}

}
