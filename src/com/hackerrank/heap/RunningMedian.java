package com.hackerrank.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {

	private static PriorityQueue<Integer> min = new PriorityQueue<>();
	private static double median = 0;
	private static PriorityQueue<Integer> max = new PriorityQueue<Integer>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}

	});

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int i = 0; i < n; i++) {
			printMedian(scn.nextInt());
		}
		scn.close();
	}

	private static void printMedian(int number) {

		if (number > median) {
			min.add(number);
		} else {
			max.add(number);
		}
		int diff = Math.abs(min.size() - max.size());
		if (diff > 1 && min.size() > max.size()) {
			max.add(min.poll());
		} else if (diff > 1 && min.size() < max.size()) {
			min.add(max.poll());
		}

		double val = 0;
		if (min.size() == max.size()) {
			val = (double) (min.peek() + max.peek()) / 2;
			System.out.println(val);
		} else if (min.size() > max.size()) {
			val = (min.peek());
			System.out.println((double) (min.peek()));
		} else {
			val = (max.peek());
			System.out.println((double) (max.peek()));
		}
		median = val;
	}
}
