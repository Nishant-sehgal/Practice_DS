package com.hackerrank.queue;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingStack {

	static Stack<Integer> stack1 = new Stack<>();
	static Stack<Integer> stack2 = new Stack<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int operations = sc.nextInt();
		for (int i = 0; i < operations; i++) {
			int type = sc.nextInt();
			if (type == 1) {
				int val = sc.nextInt();
				enquee(val);
			}
			if (type == 2) {
				dequee();
			} else if (type == 3) {
				print();
			}

		}
		sc.close();
	}

	public static void enquee(int val) {
		stack1.push(val);
	}

	public static void dequee() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		stack2.pop();
	}

	public static void print() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		System.out.println(stack2.peek());
	}

}
