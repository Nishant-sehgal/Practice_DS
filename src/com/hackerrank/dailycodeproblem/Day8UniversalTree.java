package com.hackerrank.dailycodeproblem;

public class Day8UniversalTree {

	public static void main(String[] args) {

		Node<Integer> node = new Node<>(0);

		Node<Integer> level1 = new Node<Integer>(1);

	/*	level1.left = new Node<Integer>(1);
		level1.right = new Node<Integer>(0);*/

		Node<Integer> level2 = new Node<Integer>(0);
		Node<Integer> child = new Node<Integer>(1);
		child.left=new Node<Integer>(1);
		child.right=new Node<Integer>(1);
		level2.left = child;
		level2.right = new Node<Integer>(0);

		node.left = level1;
		node.right = level2;
		System.out.println(count(node));
	}

	static int count = 0;

	public static int count(Node<Integer> n) {
		if (n != null) {
			if (checkUniveral(n, n.val)) {
				count++;
			}
			count(n.left);
			count(n.right);
		}
		return count;
	}

	public static boolean checkUniveral(Node<Integer> n, int val) {
		if (n.val != val) {
			return false;
		}
		if (n != null && n.left == null & n.right == null) {
			return true;
		}
		return checkUniveral(n.left, val) && checkUniveral(n.right, val);
	}
}
