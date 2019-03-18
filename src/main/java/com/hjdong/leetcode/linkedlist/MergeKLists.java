package com.hjdong.leetcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
	public static void main(String[] args) {

	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode nn,head;
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val > o2.val) {
					return 1;
				} else if (o1.val < o2.val) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		for (int i = 0; i < lists.length; i++) {
			if (null != lists[i]) {
				pq.add(lists[i]);
			}
		}
		head = pq.poll();
		nn = head;
		
		while (!pq.isEmpty()) {
			if (nn.next != null) {
				pq.add(nn.next);
			}
			nn.next = pq.poll();
			nn = nn.next;
		}
		
		
		return head;
		
	}
}
