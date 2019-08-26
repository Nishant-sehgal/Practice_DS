package hackerrank.linkedlist.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {

		Node n = new Node();
		n.data = 1;
		Node t = new Node();
		t.data = 2;
		n.next = t;

		Node r = new Node();
		r.data = 2;
		t.next = r;

		Node s = new Node();
		s.data = 3;
		r.next = s;

		SortedInsert(SortedInsert(SortedInsert(SortedInsert(null, 2), 1), 4), 3);
	}

	int FindMergeNode(Node headA, Node headB) {

		Map<Integer, Integer> map = new HashMap<>();
		while (headA != null) {
			if (map.containsKey(headA.data)) {
				return headA.data;
			} else {
				map.put(headA.data, 1);
			}
		}
		while (headB != null) {
			if (map.containsKey(headB.data)) {
				return headB.data;
			} else {
				map.put(headB.data, 1);
			}
		}
		return 0;
	}

	static Node SortedInsert(Node head, int data) {
		if (head == null) {
			Node n = new Node();
			n.data = data;
			head = n;
			return head;
		}
		Node current = head;
		Node prev = head;
		while (current != null) {
			if (current.data > data) {
				Node n1 = new Node();
				n1.data = data;
				n1.next = prev;
				return n1;
			}
			if (current.next == null) {
				Node n1 = new Node();
				n1.data = data;
				current.next = n1;
				return head;
			}
			prev = current;
			current = current.next;
		}
		return head;
	}

	static Node RemoveDuplicates(Node head) {
		Node node1 = head;
		while (node1.next != null) {
			if (node1.data == node1.next.data) {
				node1.next = node1.next.next;
			} else {
				node1 = node1.next;
			}
		}
		return head;
	}

	static int GetNode(Node head, int n) {
		Node element = head;
		Node pointer = head;
		while (pointer.next != null) {
			while (n > 0) {
				pointer = pointer.next;
				n--;
			}
			element = element.next;
			pointer = pointer.next;
		}
		return element.data;
	}

	static Node Insert(Node head, int data) {
		Node temp = new Node();
		temp.data = data;
		temp.next = null;
		if (head != null) {
			temp.next = head;
		}
		return temp;
	}

	static Node Delete(Node head, int position) {
		// This is a "method-only" submission.
		// You only need to complete this method.
		int currentPosition = 0;
		Node current = head;
		Node previous = head;
		while (currentPosition != position) {
			currentPosition++;
			previous = current;
			current = current.next;
		}
		if (position == 0) {
			head = head.next;
		} else {
			if (current != null) {
				previous.next = current.next;
			}
		}
		return head;

	}

	static Node InsertNth(Node head, int data, int position) {
		// This is a "method-only" submission.
		// You only need to complete this method.
		Node n = new Node();
		n.data = data;
		n.next = null;
		int currentPosition = 0;
		Node current = head;
		Node previous = head;
		while (currentPosition != position) {
			currentPosition++;
			previous = head;
			current = current.next;
		}
		if (head == null) {
			return n;
		}
		if (position == 0) {
			n.next = head;
			return n;
		}
		Node temp = previous.next;
		previous.next = n;
		n.next = temp;
		return head;
	}

	void ReversePrint(Node head) {
		// This is a "method-only" submission.
		// You only need to complete this method.
		if (head != null) {
			Stack<Integer> s = new Stack<>();
			while (head != null) {
				s.push(head.data);
				head = head.next;
			}
			while (!s.isEmpty()) {
				System.out.println(s.pop());
			}
		}
	}

	static Node Reverse(Node head) {
		if (head != null) {
			int first = head.data;
			int second = head.next.data;
			Node current = head.next;
			Node f1 = new Node();
			f1.data = first;

			Node f2 = new Node();
			f2.data = second;
			f2.next = f1;
			current = current.next;
			while (current != null) {
				Node next = new Node();
				next.data = current.data;
				Node temp = current.next;
				next.next = f2;
				f2 = next;
				current = temp;
			}
			return f2;
		}
		return head;
	}

	static Node mergeLists(Node headA, Node headB) {
		// This is a "method-only" submission.
		// You only need to complete this method
		Node newNode = new Node();
		while (headA != null && headB != null) {
			Node temp = newNode;
			while (temp.next != null) {
				temp = temp.next;
			}
			if (headA.data > headB.data) {
				temp.data = headB.data;
				temp.next = new Node();
				headB = headB.next;
			} else {
				temp.data = headA.data;
				temp.next = new Node();
				headA = headA.next;
			}
		}
		while (headA != null) {
			Node temp = newNode;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.data = headA.data;
			if (headA.next != null) {
				temp.next = new Node();
			}
			headA = headA.next;
		}
		while (headB != null) {
			Node temp = newNode;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.data = headB.data;
			if (headB.next != null) {
				temp.next = new Node();
			}
			headB = headB.next;
		}
		return newNode;
	}
}

class Node {
	int data;
	Node next;
	Node prev;
}