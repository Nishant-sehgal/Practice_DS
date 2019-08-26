package com.hackerrank.stack;

import java.util.Scanner;
import java.util.Stack;

public class DownToZero {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int Q = in.nextInt();
		for (int a0 = 0; a0 < Q; a0++) {
			printMoves(in.nextInt());
		}
		in.close();

	}

	public static void printMoves(int n) {
		Stack<Integer> stack = new Stack<>();
		stack.push(n);
		int min = 0;
		while (!stack.isEmpty() && stack.peek() != 0) {
			int val = getMax(stack.pop());
			System.out.println(val);
			stack.push(val);
			min++;
		}
		System.out.println(min);
	}

	private static int getMax(int n) {
		int min = Integer.MAX_VALUE;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				min = Math.min(min, n / i);
			}
		}
		return Math.min(min,n - 1);
	}

}
