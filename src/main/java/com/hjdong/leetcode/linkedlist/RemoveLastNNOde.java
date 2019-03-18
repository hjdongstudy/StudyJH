package com.hjdong.leetcode.linkedlist;

public class RemoveLastNNOde {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int i = 1;
		ListNode kuain = head;
		while(i < n) {
			kuain = kuain.next;
			i ++;
			if (null == kuain) {
				return null;
			}
		}
		
		ListNode mann = head;
		ListNode mannpre = null;
		while(true) {
			if (kuain.next != null) {
				mannpre = mann;
				mann = mann.next;
				kuain = kuain.next;
			} else {
				break;
			}
			
		}
		
		if (mannpre == null) {
			return head = mann.next;
		} else {
			mannpre.next = mannpre.next.next;
		}
		
		
		return head;
	}

}
