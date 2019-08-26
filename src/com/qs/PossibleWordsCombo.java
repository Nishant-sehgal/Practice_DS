package com.qs;

public class PossibleWordsCombo {

	static void wordsCombo(String str) {
		String[] inputarray = str.split(" ");
		print(inputarray, 0, inputarray.length, "");
	}

	static void print(String[] str, int s, int e, String output) {

		if (s == e) {
			System.out.println(output.substring(0, output.length() - 1));
		}
		for (int i = s; i < e; i++) {
			if (i == s) {
				output += str[i];
			} else {
				output += " " + str[i];
			}
			print(str, i + 1, e, output + ",");
		}
	}

	public static void main(String[] args) {
		wordsCombo("Hello how are you");
	}
}
