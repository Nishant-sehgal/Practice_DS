package com.program;

public class ReverseLinkList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkNode n1 = new LinkNode(1);
		/*n1.setNext(new LinkNode(2));
		n1.getNext().setNext(new LinkNode(3));
		n1.getNext().getNext().setNext(new LinkNode(4));*/
		// reverse(n1);
		reverseRec(n1);
		System.out.println();
	}

	static LinkNode head;

	public static LinkNode reverseRec(LinkNode n1) {

		if(n1==null){
			return null;
		}
		if (n1.getNext() != null) {
			LinkNode temp = reverseRec(n1.next);
			temp.setNext(n1);
			if (head == null) {
				head = temp;
			}
			n1.setNext(null);
			n1 = temp.getNext();
		}
		return n1;
	}

	public static void reverse(LinkNode n1) {
		LinkNode prev = null, current = n1, next = null;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		n1 = prev;
		System.out.println(n1);
	}
}

class LinkNode {
	int data;
	public LinkNode next;

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
	 * @return the next
	 */
	public LinkNode getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(LinkNode next) {
		this.next = next;
	}

	/**
	 * @param data
	 */
	public LinkNode(int data) {
		super();
		this.data = data;
	}

}