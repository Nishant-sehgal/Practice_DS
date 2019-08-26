package com.qs;

public class ReverseKGroupLinkedList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		reverseKGroup(l1, 2);
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode cur = head, prev = null, next = null;

		while (cur != null & k != 0) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
			k--;
		}
		head.next = reverseKGroup(head, k);
		return prev;
	}

}