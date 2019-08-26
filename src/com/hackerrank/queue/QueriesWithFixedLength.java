package com.hackerrank.queue;

import java.util.Deque;
import java.util.LinkedList;

public class QueriesWithFixedLength {

	public static void main(String[] args) {
		findResult(new int[] { 1,3,-1,-3,5,3,6,7}, 3);
	}

	public static Integer findResult(int[] arr, int number) {
		int maxSoFar = -1;
		int minVal = Integer.MAX_VALUE;
		Deque<Integer> deq = new LinkedList<>();
		int i = 0;
		for (i = 0; i < number; i++) {
			while (!deq.isEmpty() && arr[i] >= arr[deq.peekLast()]) {
				deq.removeLast();
			}
			deq.addLast(i);
		}

		for (; i < arr.length; i++) {
			maxSoFar = arr[deq.peek()];
			if (minVal > maxSoFar) {
				minVal = maxSoFar;
			}
			while (!deq.isEmpty() && deq.peek() <= i - number) {
				deq.removeFirst();
			}
			while (!deq.isEmpty() && arr[i] >= arr[deq.peekLast()]) {
				deq.removeLast();
			}
			deq.addLast(i);
		}
		maxSoFar = arr[deq.peek()];
		if (minVal > maxSoFar) {
			minVal = maxSoFar;
		}
		return minVal;
	}
}
