package com.hjdong.leetcode.linkedlist;

public class ReverseKNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
//		ListNode n3 = new ListNode(3);
//		ListNode n4 = new ListNode(4);
//		ListNode n5 = new ListNode(5);
		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
		n2.next = null;
		
		ReverseKNode rk = new ReverseKNode();
		ListNode n = rk.swapPairsreverseKGroup(n1, 3);
		System.out.println(n);
	}

	public ListNode swapPairsreverseKGroup(ListNode head, int k) {
		if (null == head || head.next == null || 1 == k || 0 == k) {
			return head;
		}
        ListNode newhead = null,slowpre = null,kpre = null;
        ListNode fastnode = head;
        ListNode slownode = head;
        ListNode slownode2 = null;
        ListNode tmpstartK = null;
        
        
		while (true) {
			tmpstartK = fastnode;
			// 不足k个则直接返回
			for (int i = 1; i < k; i++) {
				if (null == fastnode) {
					if (null == kpre) {
						return head;
					} else {
						kpre.next = tmpstartK;
					}
					break;
				}
				fastnode = fastnode.next;
			}
			if (null == fastnode) { //如果剩余节点不足k个，直接结束
				if (null == kpre) {
					return head;
				} else {
					kpre.next = tmpstartK;
				}
				break;
			} 
			
			// 进行反转
			while (slownode != fastnode) {
				slownode2 = slownode.next;
				slownode.next = slowpre;
				slowpre = slownode;
				slownode = slownode2;
			}
			fastnode = fastnode.next;
			
			slownode.next = slowpre;
			slowpre = slownode;
			
			if (null == newhead) {
				newhead = slownode;
			}
			if (null != kpre) {
				kpre.next = slownode;
			}
			
			kpre = tmpstartK;
			
			
			slownode = fastnode;
		}
        
        
		if (null == newhead) {//长度不足k，直接返回原有head
			return head;
		} else {
			return newhead;
		}
    }

}
