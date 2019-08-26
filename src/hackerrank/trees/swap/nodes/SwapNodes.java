package hackerrank.trees.swap.nodes;

import java.util.Scanner;

public class SwapNodes {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		Node root = new Node();
		root.data = 1;
		for (int i = 1; i <= N; i++) {
			int n1 = scanner.nextInt();
			int n2 = scanner.nextInt();

			Node temp = find(root, i);
			if (temp.data == i) {
				if (n1 != -1) {
					Node nodeLeft = new Node();
					nodeLeft.data = n1;
					temp.left = nodeLeft;
				}
				if (n2 != -1) {
					Node nodeRight = new Node();
					nodeRight.data = n2;
					temp.right = nodeRight;
				}
			}

		}
		int depth = scanner.nextInt();
		int treeDepth = calculateDepth(root, 1);
		for (int i = 0; i < depth; i++) {
			int depthVal = scanner.nextInt();
			int depthMultiplier = 1;
			int deptSum = depthVal * depthMultiplier;
			while (deptSum <= treeDepth) {
				swap(root, deptSum, 1);
				depthMultiplier++;
				deptSum = depthVal * depthMultiplier;
			}
			inOrder(root);
			System.out.println();
		}
		scanner.close();

	}

	public static int calculateDepth(Node root, int count) {
		int leftCount = count, rightCount = count;
		if (root != null) {
			if (root.left != null) {
				leftCount++;
				leftCount = calculateDepth(root.left, leftCount);
			}
			if (root.right != null) {
				rightCount++;
				rightCount = calculateDepth(root.right, rightCount);
			}
		}
		if (leftCount > rightCount) {
			return leftCount;
		} else {
			return rightCount;
		}
	}

	public static Node find(Node n, int val) {
		if (n.data == val) {
			return n;
		} else {
			if (n.left != null) {
				Node left = find(n.left, val);
				if (left != null) {
					return left;
				}
			}
			if (n.right != null) {
				Node right = find(n.right, val);
				if (right != null) {
					return right;
				}
			}
		}
		return null;
	}

	public static void inOrder(Node root) {
		if (root != null) {
			if (root.left != null) {
				inOrder(root.left);
			}
			System.out.print(root.data + " ");
			if (root.right != null) {
				inOrder(root.right);
			}
		}
	}

	public static void swap(Node root, int depth, int currentDepth) {
		if (root != null) {
			if (currentDepth == depth) {
				Node temp = root.left;
				root.left = root.right;
				root.right = temp;
			} else {
				currentDepth++;
				swap(root.left, depth, currentDepth);
				swap(root.right, depth, currentDepth);
			}
		}
	}

}

class Node {
	int data;
	Node left;
	Node right;
}