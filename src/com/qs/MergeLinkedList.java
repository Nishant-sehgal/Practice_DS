package com.qs;

public class MergeLinkedList {

	public static void main(String[] args) {
		ListNodee l1 = new ListNodee(1);
		ListNodee l2 = new ListNodee(1);
		ListNodee l3 = new ListNodee(2);
		ListNodee l4 = new ListNodee(4);
		l1.next = l3;
		l2.next = l4;
		mergeTwoLists(l1, l2);
	}

	public static ListNodee mergeTwoLists(ListNodee l1, ListNodee l2) {
		ListNodee head = null;
		if (null == l1) {
			return l2;
		}
		if (null == l2) {
			return l1;
		}
		ListNodee tail = null;
		while (null != l2 && null != l1) {
			ListNodee temp = null;
			if (l2.val > l1.val) {
				temp = new ListNodee(l1.val);
				l1 = l1.next;
			} else {
				temp = new ListNodee(l2.val);
				l2 = l2.next;
			}
			if (head == null) {
				head = temp;
				tail = temp;
			} else {
				tail.next = temp;
				tail = tail.next;
			}
			
		}

		while (null != l1) {
			tail.next = l1;
			l1 = l1.next;
			tail = tail.next;
		}

		while (null != l2) {
			tail.next = l2;
			l2 = l2.next;
			tail = tail.next;
		}
		return head;
	}

}

class ListNodee {
	int val;
	ListNodee next;

	ListNodee(int x) {
		val = x;
	}
}
