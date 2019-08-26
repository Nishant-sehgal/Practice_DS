package com.program;

public class CustomQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class CustomQ {
	private int[] queueArr;
	private int front = 0;
	private int MAX = 10;
	private int rear = 0;
	private int size = 0;

	public CustomQ() {
		queueArr = new int[MAX];
	}

	public void enqueue(int val) {
		if ((rear + 1) % MAX == front) {
			return;
		} else {
			queueArr[rear] = val;
			rear = (rear + 1) % MAX;
			size++;
		}
	}

	public int poll() {
		if (size == 0) {
			return -1;
		}
		int val = queueArr[front];
		front = (front + 1) % MAX;
		return val;
	}
}
