package com.thread;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBlockingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

class CustomQueue<T> {
	private Queue<T> queue = new LinkedList<>();
	private final int CAPACITY;

	CustomQueue(int size) {
		this.CAPACITY = size;
	}

	public void add(T value) throws InterruptedException {
		synchronized (this) {
			while (queue.size() == CAPACITY) {
				wait();
			}
			queue.add(value);
			notifyAll();
		}
	}

	public T remove() throws InterruptedException {
		synchronized (this) {
			while (queue.isEmpty()) {
				wait();
			}
			T val = queue.remove();
			notifyAll();
			return val;
		}
	}
}
