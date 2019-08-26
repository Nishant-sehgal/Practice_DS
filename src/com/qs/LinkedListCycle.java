package com.qs;

public class LinkedListCycle {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);
		n4.next = n2;
		n2.next=n3;
		n3.next = n4;
		n1.next=n2;
		hasCycle(n1);
	}

	public static boolean hasCycle(ListNode head) {
		if (null == head) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = slow.next;
		while (fast != null && fast.next != null) {
			if (slow.val == fast.val) {
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}

}
