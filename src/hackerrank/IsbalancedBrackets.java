package hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class IsbalancedBrackets {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println((isBalanced(expression)) ? "YES" : "NO");
		}

	}

	public static boolean isBalanced(String expression) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '{' || expression.charAt(i) == '[' || expression.charAt(i) == '(') {
				stack.push(expression.charAt(i));
			} else if (expression.charAt(i) == '}' || expression.charAt(i) == ']' || expression.charAt(i) == ')') {
				char c = '\0';
				if (!stack.isEmpty()) {
					c = stack.pop();
				}
				if (c == '\0' || !(returnMatchinBracket(expression.charAt(i)) == c)) {
					return false;
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

	public static char returnMatchinBracket(char bracket) {
		char outputChar = '}';
		switch (bracket) {
		case '}':
			outputChar = '{';
			break;
		case ']':
			outputChar = '[';
			break;
		case ')':
			outputChar = '(';
			break;
		}
		return outputChar;
	}
}
