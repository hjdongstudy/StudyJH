package com.hjdong.dsc.linklist;

public class LinkedListTest {

	public static void main(String[] args) {
//		 * 1) 单链表反转
//		testReverse();
//		 * 2) 链表中环的检测
//		testCircleLL();

//		 * 4) 删除链表倒数第n个结点
//		testRemoveLastN();
//		Node head = LLUtils.initll(9);
//		testRemoveLastKSmart(head, 6);
//		LLUtils.printAll(head);

//		 * 5) 求链表的中间结点		
		findMidNodeALL(LLUtils.initll(9));
		findMidNodeALL(LLUtils.initll(8));
		findMidNodeALL(LLUtils.initll(1));
		findMidNodeALL(LLUtils.initll(0));
	}
//	单链表反转 链表中环的检测 两个有序的链表合并 

	

	// 求中间结点
	  public static Node findMiddleNode(Node list) {
	    if (list == null) return null;

	    Node fast = list;
	    Node slow = list;

	    while (fast.next != null && fast.next.next != null) {
	      fast = fast.next.next;
	      slow = slow.next;
	    }

	    return slow;
	  }

	private static void findMidNodeALL(Node head) {
		int i = 1;
		Node slow = head.next;
		Node fast = head.next;
		while(null != fast && null != fast.next) {
			slow = slow.next;
			i = i + 1;
			fast = fast.next;
			if (null != fast && null != fast.next) {
				i = i + 1;
				fast = fast.next;	
			} else {
				break;
			}
		}
		
		System.out.println(i);
		System.out.println(slow);
	}




	/**
	 * 最优时间复杂度
	 */
	private static void testRemoveLastKSmart(Node lhead, int k) {
		int i = 0;
		Node q = lhead.next;
		while(i < k) {
			i ++;
			q = q.next;
			if (q == null) {
				System.err.println("input error!!");
				return;
			}
		}
		System.out.println(q);
		
		Node prep = null;
		Node p = lhead.next;
		while(q != null) {
			prep = p;
			p = p.next;
			q = q.next;
		}
		
		prep.next = p.next;
	}

	/**
	 * 123456789
	 */
	private static void testRemoveLastN() {
		int n = 4;
		Node head = LLUtils.initll(9);
		LLUtils.printAll(head);
		Node cur = head.next;
		int i = 0;
		while(cur != null) {
			i ++;
			cur = cur.next;
		}
		System.out.println(i);
		int cn = i - n + 1;
		System.out.println(cn);
		
		i = 0;
		cur = head;
		Node pre = null;
		while (i++ < cn) {
			pre = cur;
			cur = cur.next;
		}
		
		System.out.println(pre);
		System.out.println(cur);
		
		pre.next = cur.next;
		
		LLUtils.printAll(head);
		
	}



	private static void testCircleLL() {
		Node head = LLUtils.initll(9);
		System.out.println(checkCircle(head));
		
		Node chead = LLUtils.initCircleHead();
		
//		printAll(initCircleHead());
		//是否有环的监测
		System.out.println(checkCircle(chead));
		//求环的长度
		System.out.println(getCircleLen(chead));
		//求换的起始点--需要考虑起始点就是环起点的情况
		System.out.println(getCirStartNode(chead));
	}

	private static void testReverse() {
		Node head = LLUtils.initll(9);
		reverseSim(head);
		LLUtils.printAll(head);
		
		head = LLUtils.initll(0);
		reverseSim(head);
		LLUtils.printAll(head);
		
		head = LLUtils.initll(1);
		reverseSim(head);
		LLUtils.printAll(head);
		
		head = LLUtils.initll(2);
		reverseSim(head);
		LLUtils.printAll(head);
		
	}
	/**
	 * 原理：快遍历是否可以追上慢便利
	 * @param head
	 * @return
	 */
	public static boolean checkCircle(Node head) {
		boolean isCircle = false;
		Node slow = head.next,fast = head.next;
		while (true) {
			slow = slow.next;
			fast = fast.next;
			if (null == fast) {
				break;
			} else {
				fast = fast.next;
			}
			
			if (null == slow || null == fast) {
				break;
			}
			
			if (slow == fast) {
				isCircle = true;
//				System.out.println(slow);
				break;
			}
		}
		return isCircle;
	}
	
	/**
	 * 原理：快遍历是否可以追上慢遍历，追上后再次相遇时，快遍历比慢遍历多跑一圈，多遍历的就是环的长度
	 * @param head
	 * @return
	 */
	public static int getCircleLen(Node head) {
		boolean isCircle = false;
		Node slow = head.next,fast = head.next;
		int metc = 0, slowc = 0, fastc = 0;
		while (true) {
			slow = slow.next;
			fast = fast.next;
			if (null == fast) {
				break;
			} else {
				fast = fast.next;
			}
			
			if (null == slow || null == fast) {
				break;
			}
			
			slowc ++;
			fastc = fastc + 2;
			
			if (slow == fast) {
				isCircle = true;
//				System.out.println(slow);
				if (metc ++ == 2) 
					break;
				slowc = 0;
				fastc = 0;
			}
		}
		
		return fastc - slowc;
	}
	
	/**
	 * 这里先证明一个定理：碰撞点到连接点的距离=头指针到连接点的距离
	 * 假设单链表的总长度为L，头结点到环入口的距离为a，环入口到快慢指针相遇的结点距离为x，环的长度为r，慢指针总共走了s步，则快指针走了2s步。另外，快指针要追上慢指针的话快指针至少要在环里面转了一圈多(假设转了n圈加x的距离)，得到以下关系：
    s = a + x
    2s = a + nr + x
    =>a + x = nr
    =>a = nr - x
	 * 
	 * @param chead
	 * @return
	 */
	private static Node getCirStartNode(Node head) {
		boolean isCircle = false;
		Node slow = head.next,fast = head.next;
		int metc = 0, slowc = 0, fastc = 0;
		while (true) {
			slow = slow.next;
			fast = fast.next;
			if (null == fast) {
				break;
			} else {
				fast = fast.next;
			}
			
			if (null == slow || null == fast) {
				break;
			}
			
			slowc ++;
			fastc = fastc + 2;
			
			if (slow == fast) {
				isCircle = true;
//				System.out.println(slow);
				break;
			}
		}
		
		fast = head.next;
		while(true) {
			if (fast == slow) {
				break;
			}
			fast = fast.next;
			slow = slow.next;
		}
		
		return fast;
	}
	
	/**
	 * 带有头结点的链表翻转
	 * @param head
	 */
	public static void reverseSim(Node head) {
		Node cur = head.next;
		Node previous = null;
		
		Node tmp;
		while (cur != null) {
			tmp = cur.next;
			cur.next = previous;
			previous = cur;
			cur = tmp;
		}
		
		head.next = previous;
	}
	
	
	/**
	 * 带有头结点的链表翻转
	 * @param head
	 */
	public static void reverse(Node head) {
		Node p = head.next;
		//1. 空链表直接返回
		if (null == p) {
			return;
		}
		//2. 只有一个元素直接返回
		if (null == p.next) {
			return;
		}
		//当前头结点变为尾节点
		Node last = p;
		Node q = p.next;
		Node tmpq;
		while (null != q) {
			tmpq = q.next;
			q.next = p;
			p = q;
			q = tmpq;
		}
		head.next = p;//找到头结点
		last.next = null;//尾巴节点指向null
		
	}
	
	
	
	
}
