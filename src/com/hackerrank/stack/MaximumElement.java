package com.hackerrank.stack;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		Stack<Integer> orig = new Stack<>();
		Stack<Integer> max = new Stack<>();
		max.push(-1);
		for (int i = 0; i < n; i++) {
			int op = scn.nextInt();

			if (op == 1) {
				int val = scn.nextInt();
				push(orig, max, val);
			} else if (op == 2) {
				delete(orig, max);
			} else if (op == 3) {
				print(orig, max);
			}
		}
		scn.close();
	}

	public static void push(Stack<Integer> orig, Stack<Integer> max, int number) {
		orig.push(number);
		if (!orig.isEmpty() && max.peek() < number) {
			max.push(number);
		}else{
			max.push(max.peek());
		}
	}

	public static void delete(Stack<Integer> orig, Stack<Integer> max) {
		orig.pop();
		max.pop();
	}

	public static void print(Stack<Integer> orig, Stack<Integer> max) {
		System.out.println(max.peek());
	}

}
