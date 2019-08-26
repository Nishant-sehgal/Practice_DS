package com.hackerrank.dailycodeproblem;

public class Day3SerializeBinaryTree {
	static int start = 0;

	public static void main(String[] args) {

		Node<Integer> node = new Node<>(0);

		Node<Integer> level1 = new Node<Integer>(1);

		level1.left = new Node<Integer>(3);
		level1.right = new Node<Integer>(4);

		Node<Integer> level2 = new Node<Integer>(2);
		level2.left = new Node<Integer>(5);
		level2.right = new Node<Integer>(6);

		node.left = level1;
		node.right = level2;

		StringBuilder output = new StringBuilder();
		serialize(node, output);
		System.out.println(output.toString());

		StringBuilder newOutput = new StringBuilder();
		Node<Integer> n = deserialize(output.toString());
		serialize(n, newOutput);
		System.out.println(newOutput.toString());
	}

	public static Node<Integer> deserialize(String deserializeString) {
		if (start == deserializeString.length()) {
			return null;
		}
		String val = deserializeString.charAt(start++) + "";
		if ("X".equals(val)) {
			return null;
		}
		Node<Integer> n = new Node<>(Integer.valueOf(val));
		n.left = deserialize(deserializeString);
		n.right = deserialize(deserializeString);
		return n;
	}

	public static void serialize(Node<Integer> node, StringBuilder newOutput) {
		if (node == null) {
			newOutput.append("X");
			return;
		}
		newOutput.append(node.val + "");
		serialize(node.left, newOutput);
		serialize(node.right, newOutput);
	}

}

class Node<T> {

	T val;
	Node<T> left;
	Node<T> right;

	Node(T value) {
		this.val = value;
	}

}