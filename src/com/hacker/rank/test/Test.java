package com.hacker.rank.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {

	public static void main(String[] args) {
		/*
		 * long[] op = maxMin(new String[]{"push","push"}, new int[] {3,2});
		 * System.out.println(Arrays.toString(op));
		 */
		System.out.println(waitingTime(new int[] {2,6,3,4,5 }, 2));
	}

	static long waitingTime(int[] tickets, int p) {
		long times = 0;
		int[] temp = Arrays.copyOf(tickets, tickets.length);
		for (int i = 0; i < tickets.length; i++) {
			temp[i] = tickets[i] - tickets[p];
		}
		for (int i = 0; i < tickets.length; i++) {
			if (temp[i] < 0) {
				times += tickets[i];
			} else {
				if (i <= p)
					times += tickets[p];
				else
					times += tickets[p] - 1;
			}
		}
		return times;
	}

	static long[] maxMin(String[] operations, int[] x) {
		long[] ouput = new long[operations.length];
		int i = 0;
		PriorityQueue<Long> min = new PriorityQueue<>();
		PriorityQueue<Long> max = new PriorityQueue<>(new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				return o2.compareTo(o1);
			}
		});

		for (int j = 0; j < ouput.length; j++) {
			if (operations[j].equalsIgnoreCase("push")) {
				min.add((long) x[j]);
				max.add((long) x[j]);
			} else {
				min.remove((long) x[j]);
				max.remove((long) x[j]);
			}
			ouput[i++] = min.peek() * max.peek();
		}
		return ouput;

	}
}
