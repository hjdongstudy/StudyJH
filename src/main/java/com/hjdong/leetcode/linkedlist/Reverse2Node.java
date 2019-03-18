package com.hjdong.leetcode.linkedlist;

public class Reverse2Node {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode swapPairs(ListNode head) {
        if (null == head || head.next == null) {
        	return head;
        }
        ListNode newhead = head.next;
        
        ListNode f = head, s = head.next, ssuffix = null, fpre = null;
        while (null != f) {
        	if (s == null) {
        		break;
        	}
        	
        	ssuffix = s.next;
        	s.next = f;
        	if (fpre != null) {
        		fpre.next = s;
        	}
        	if (ssuffix != null) {
        		f.next = ssuffix;
        		fpre = f;
        		f = ssuffix;
        		s = f.next;
        	} else {
        		f.next = null;
        		break;
        	}
        }
		
		return newhead;
    }

}
