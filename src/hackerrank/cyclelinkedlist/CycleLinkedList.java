package hackerrank.cyclelinkedlist;

import java.util.HashSet;
import java.util.Set;

public class CycleLinkedList {

	public static void main(String[] args) {

	}

	boolean hasCycle(Node head) {
		Set<Node> visited = new HashSet<>();
		if (head == null) {
			return false;
		}
		Node tempNode = head;
		while (tempNode != null) {
			if (!visited.contains(tempNode)) {
				visited.add(tempNode);
				tempNode = tempNode.next;
			} else {
				return true;
			}
		}
		return false;
	}

}

class Node {
	int data;
	Node next;
}