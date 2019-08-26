package com.qs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);

		l1.next = l2;
		l2.next = l3;

		l4.next = l5;
		l5.next = l6;

		l7.next = l8;
		mergeKLists(new ListNode[] { l1, l4, l7 });
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		ListNode head = null, tail = null;
		for (int i = 0; i < lists.length; i++) {
			heap.add(lists[i]);
		}
		while (!heap.isEmpty()) {
			ListNode temp = heap.poll();
			if (null != temp.next) {
				heap.add(temp.next);
			}
			temp.next = null;
			if (null == head) {
				head = temp;
				tail = temp;
			} else {
				tail.next = temp;
				tail = tail.next;
			}

		}
		return null;
	}
}
