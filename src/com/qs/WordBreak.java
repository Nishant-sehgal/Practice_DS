package com.qs;

public class WordBreak {

	public static void main(String[] args) {
		wordBreak("iloveicecreamandmango");
	}	

	// Prints all possible word breaks of given string
	static void wordBreak(String str) {
		// last argument is prefix
		wordBreakUtil(str, str.length(), "");
	}

	static boolean dictionaryContains(String word) {
		String dictionary[] = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i",
				"love", "ice", "cream" };
		int n = dictionary.length;
		for (int i = 0; i < n; i++)
			if (dictionary[i].compareTo(word) == 0)
				return true;
		return false;
	}

	// result store the current prefix with spaces
	// between words
	static void wordBreakUtil(String str, int n, String result) {
		// Process all prefixes one by one
		for (int i = 1; i <= n; i++) {
			// extract substring from 0 to i in prefix
			String prefix = str.substring(0, i);

			// if dictionary conatins this prefix, then
			// we check for remaining string. Otherwise
			// we ignore this prefix (there is no else for
			// this if) and try next
			if (dictionaryContains(prefix)) {
				// if no more elements are there, print it
				if (i == n) {
					// add this element to previous prefix
					result += prefix;
					System.out.println(result);
					return;
				}
				wordBreakUtil(str.substring(i, n), n - i, result + prefix + " ");
			}
		} // end for
	}// end function
}
