package com.verticaltraversal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class VerticalViewTree {
	Node root;
	ArrayList<Integer> arr = new ArrayList<>();
	static Map<Integer, ArrayList<Integer>> mymap = new LinkedHashMap<Integer, ArrayList<Integer>>();

	static class Node {
		int key;
		Node left;
		Node right;

		public Node(int i) {
			this.key = i;
			left = null;
			right = null;
		}
	}

	VerticalViewTree() {
		root = null;
	}

	VerticalViewTree(int key) {
		root = new Node(key);
	}

	public Map<Integer, ArrayList<Integer>> findMinMax(Node root, int val) {
		if (root.left != null) {
			findMinMax(root.left, val - 1);
		}

		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		if (mymap.get(val) != null) {

			arrlist = mymap.get(val);
			arrlist.add(root.key);

		} else {
			arrlist.add(root.key);
		}

		mymap.put(val, arrlist);

		if (root.right != null) {
			findMinMax(root.right, val + 1);
		}

		return mymap;
	}

	public void printTree(Node root) {
		if (root == null) {
			return;
		}

		Map<Integer, ArrayList<Integer>> map = findMinMax(root, 0);

		for (Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
			ArrayList<Integer> arr = e.getValue();
			for (Integer i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		VerticalViewTree treeobj = new VerticalViewTree();
		treeobj.root = new Node(1);
		treeobj.root.left = new Node(2);
		treeobj.root.left.left = new Node(4);
		treeobj.root.left.right = new Node(5);
		treeobj.root.right = new Node(3);
		treeobj.root.right.left = new Node(6);
		treeobj.root.right.right = new Node(7);
		treeobj.root.right.left.right = new Node(8);
		treeobj.root.right.right.right = new Node(9);

		treeobj.printTree(treeobj.root);

	}

}
