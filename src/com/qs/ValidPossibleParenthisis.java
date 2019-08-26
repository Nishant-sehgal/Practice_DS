 package com.qs;

public class ValidPossibleParenthisis {

	public static void main(String[] args) {
		printValid(2, 2, "");
	}

	static void printValid(int open, int close, String output) {

		if (open == 0 && close == 0) {
			System.out.println(output);
		}
		if(open > close){
			return;
		}
		if (open > 0) {
			printValid(open-1, close, output + "(");
		}

		if (close > 0) {
			printValid(open, close-1, output + ")");
		}
	}
}
