package hackerank.tree.bst;

import java.util.HashSet;
import java.util.Set;

public class CheckBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Node node4 = new Node(4); Node node2 = new Node(2); Node node6 = new
		 * Node(6); Node node1 = new Node(1); Node node3 = new Node(3); Node
		 * node5 = new Node(5); Node node7 = new Node(7); node4.setLeft(node2);
		 * node2.setLeft(node1); node2.setRight(node3); node4.setRight(node6);
		 * node6.setLeft(node5); node6.setRight(node7);
		 * System.out.println(checkBST(node4));
		 */
		Node node4 = new Node(4);
		Node node2 = new Node(2);
		Node node6 = new Node(6);
		Node node1 = new Node(1);
		Node node3 = new Node(3);
		Node node5 = new Node(5);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		Node node14 = new Node(14);
		Node node15 = new Node(15);

		node8.setLeft(node4);
		node8.setRight(node13);
		node4.setLeft(node2);
		node4.setRight(node6);
		node6.setLeft(node5);
		node6.setRight(node7);
		node2.setLeft(node1);
		node2.setRight(node3);

		node13.setLeft(node10);
		node13.setRight(node14);
		node10.setLeft(node9);
		node10.setRight(node11);
		node14.setLeft(node12);
		node14.setRight(node15);
		System.out.println(checkBST(node8));
	}

	static boolean checkBST(Node root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}

		return checkForBstTree(root);
	}

	static boolean checkForBstTree(Node root) {
		if (root == null) {
			return true;
		}
		Set<Integer> s =new HashSet<>();
		int max = calculateMax(root.left, 0,s);
		int min = calculateMin(root.right, Integer.MAX_VALUE, s);
		if ((root.left != null) && (root.left.data >= root.data || max >= root.data)) {
			return false;
		}
		if ((root.right != null) && (root.right.data <= root.data || min <= root.data)) {
			return false;
		}
		return checkForBstTree(root.left) && checkForBstTree(root.right);
	}

	static int calculateMin(Node root, int min, Set<Integer> set) {
		if (root != null) {
			if (set.contains(root.data)) {
				min = Integer.MIN_VALUE;
				return min;
			} else {
				set.add(root.data);
			}
			if (min > root.data) {
				min = root.data;
			}
			min = calculateMin(root.right, min, set);
			min = calculateMin(root.left, min, set);
		}
		return min;
	}

	static int calculateMax(Node root, int max, Set<Integer> set) {

		if (root != null) {
			if (set.contains(root.data)) {
				max = Integer.MAX_VALUE;
				return max;
			} else {
				set.add(root.data);
			}
			if (root.data > max) {
				max = root.data;
			}
			max = calculateMax(root.left, max, set);
			max = calculateMax(root.right, max, set);
		}
		return max;

	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the left
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * @param left
	 *            the left to set
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void setRight(Node right) {
		this.right = right;
	}
}