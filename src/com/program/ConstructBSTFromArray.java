package com.program;

public class ConstructBSTFromArray {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		root = construct(array, 0, 6);
		inorder(root);
	}

	private static Node root;

	public static Node construct(int[] array, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		Node n = new Node(array[mid]);
		n.setLeft(construct(array, start, mid - 1));
		n.setRight(construct(array, mid + 1, end));
		return n;
	}

	public static void inorder(Node n) {
		if (n == null) {
			return;
		}
		inorder(n.getLeft());
		System.out.println(n.data + "\t");
		inorder(n.getRight());
	}
}

class Node {
	int data;
	public Node left;
	public Node Right;

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
		return Right;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void setRight(Node right) {
		Right = right;
	}

}