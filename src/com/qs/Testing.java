package com.qs;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Testing {

	class Node {
		public int data;
		public Node left;
		public Node right;
	}

	static void levelOrder(Node n) {
		Queue<Node> q = new LinkedList<>();
		q.add(n);
		while (!q.isEmpty()) {
			Node val = q.poll();
			System.out.println(val.data);
			if (n.left != null) {
				q.add(n.left);
			}
			if (n.right != null) {
				q.add(n.right);
			}
		}
	}

	// 4,5,2,25
	static void nge(int[] arr) {
		Stack<Integer> s = new Stack<>();
		int len = arr.length;
		s.push(arr[0]);

		for (int i = 1; i < len; i++) {
			while (!s.isEmpty() && s.peek() < arr[i]) {
				System.out.println(s.pop() + " -->" + arr[i]);
			}
			s.push(arr[i]);
		}

		while (!s.isEmpty()) {
			System.out.println(s.pop() + " -->" + -1);
		}
	}

	// 4,5,2,25
	static void ngeOrder(int[] arr) {
		Stack<Integer> s = new Stack<>();
		int len = arr.length;
		int[] nge = new int[len];
		int k = 0;
		for (int i = len - 1; i >= 0; i--) {
			while (!s.isEmpty() && s.peek() < arr[i]) {
				s.pop();
			}
			nge[i] = s.isEmpty() ? -1 : s.peek();
			s.push(arr[i]);
		}

		for (int j = 0; j < len; j++) {
			System.out.println(arr[j] + " -->" + nge[j]);
		}
	}

	static int poisonousPlant(int[] plantArr) {
		int maxDays = 0;
		Stack<Integer> stackAlive = new Stack<>();
		for (int plantArrIdx = plantArr.length - 1; plantArrIdx > 0; plantArrIdx--) {
			final int curPlant = plantArr[plantArrIdx];
			int curDyingStreakCount = 0;
			while (!stackAlive.isEmpty() && stackAlive.peek() > curPlant) {
				// top of stackAlive dies
				stackAlive.pop();
				++curDyingStreakCount;
			}
			if (curDyingStreakCount > maxDays) {
				maxDays = curDyingStreakCount;
			}
			stackAlive.push(curPlant);
		}

		return maxDays;
	}

	static int[] pairs(int m, int[] arr) {
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i] - m)) {
				return new int[] { map.get(arr[i] - m) + 1, i + 1 };
			}
		}
		return new int[2];
	}

	public static void main(String[] args) {
		ngeOrder(new int[] { 4, 5, 2, 25 });
		// 1,8,7,6,2,3,2,4,2,5,2,6
		// System.out.println(poisonousPlant(new int[] {1 ,10 ,13 ,12 ,11 ,10
		// ,13 ,12 ,11}));
		// System.out.println(pairs(2, new int[] { 1, 5, 3, 4, 2 }));
		// merge();
	}

	private static void merge() {
		NodeN n1 = new NodeN();
		n1.data = 1;

		NodeN n2 = new NodeN();
		n2.data = 2;

		NodeN n3 = new NodeN();
		n3.data = 3;
		n1.down = n2;
		n2.down = n3;

		NodeN n4 = new NodeN();
		n4.data = 4;

		NodeN n5 = new NodeN();
		n5.data = 5;

		NodeN n6 = new NodeN();
		n6.data = 6;
		n4.down = n5;
		n5.down = n6;

		n1.next = n4;

		NodeN n7 = new NodeN();
		n7.data = 8;

		n4.next = n7;

		mergeLists(n1, n4);
	}

	static NodeN mergeLists(NodeN head1, NodeN head2) {
		NodeN head = null;
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}

		if (head1.data < head2.data) {
			head = head1;
			head1 = head1.down;
		} else {
			head = head2;
			head2 = head2.down;
		}

		NodeN current = head;
		while (head1 != null && head2 != null) {
			if (head1.data > head2.data) {
				current.down = head2;
				current = current.down;
				head2 = head2.down;
			} else {
				current.down = head1;
				current = current.down;
				head1 = head1.down;
			}
		}
		while (head1 != null) {
			current.down = head1;
			current = current.down;
			head1 = head1.down;
		}

		while (head2 != null) {
			current.down = head2;
			current = current.down;
			head2 = head2.down;
		}

		current.down = null;
		return head;
	}

}

class NodeN {
	public NodeN next, down;
	public int data;
}