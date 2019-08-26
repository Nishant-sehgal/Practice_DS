package com.hackerrank.stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	static String isBalanced(String s) {
		boolean val = true;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{') {
				stack.push('}');
			} else if (s.charAt(i) == '[') {
				stack.push(']');
			} else if (s.charAt(i) == '(') {
				stack.push(')');
			} else if (s.charAt(i) == '}') {
				if (stack.isEmpty() || stack.pop() != '}') {
					val = false;
					break;
				}
			} else if (s.charAt(i) == ']') {
				if (stack.isEmpty() ||stack.pop() != ']') {
					val = false;
					break;
				}
			} else if(s.charAt(i) == ')'){
				if (stack.isEmpty() ||stack.pop() != ')') {
					val = false;
					break;
				}
			}else{
				val=false;
				break;
			}
		}
		if(stack.isEmpty() && val){
			return "YES";
		}else{
			return "NO";
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String s = in.next();
			String result = isBalanced(s);
			System.out.println(result);
		}
		in.close();
	}

}
