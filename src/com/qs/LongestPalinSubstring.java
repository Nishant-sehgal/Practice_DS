package com.qs;

public class LongestPalinSubstring {
	// A utility function to print a substring str[low..high]
	static void printSubStr(String str, int low, int high) {
		System.out.println(str.substring(low, high + 1));
	}

	// This function prints the longest palindrome substring
	// (LPS) of str[]. It also returns the length of the
	// longest palindrome
	/*
	 * We have discussed dynamic programming solution in the previous post. The
	 * time complexity of the Dynamic Programming based solution is O(n^2) and
	 * it requires O(n^2) extra space. We can find the longest palindrome
	 * substring in (n^2) time with O(1) extra space. The idea is to generate
	 * all even length and odd length palindromes and keep track of the longest
	 * palindrome seen so far.
	 *
	 * Step to generate odd length palindrome: Fix a centre and expand in both
	 * directions for longer palindromes.
	 *
	 * Step to generate even length palindrome Fix two centre ( low and high )
	 * and expand in both directions for longer palindromes.
	 */
	static int longestPalSubstr(String str) {
		int maxLength = 1; // The result (length of LPS)

		int start = 0;
		int len = str.length();

		int low, high;

		// One by one consider every character as center
		// point of even and length palindromes
		for (int i = 1; i < len; ++i) {
			// Find the longest even length palindrome with
			// center points as i-1 and i.
			low = i - 1;
			high = i;
			while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
				if (high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}

			// Find the longest odd length palindrome with
			// center point as i
			low = i - 1;
			high = i + 1;
			while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
				if (high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}
		}

		System.out.print("Longest palindrome substring is: ");
		printSubStr(str, start, start + maxLength - 1);

		return maxLength;
	}

	// Driver program to test above function
	public static void main(String[] args) {

		String str = "a";
		System.out.println("Length is: " + longestPalSubstrDP(str));
		System.out.println(longestPalindromes(str));
	}

	// This function prints the longest palindrome substring
	// of str[].
	// It also returns the length of the longest palindrome
	static int longestPalSubstrDP(String str) {
		int n = str.length(); // get length of input string

		// table[i][j] will be false if substring str[i..j]
		// is not palindrome.
		// Else table[i][j] will be true
		boolean table[][] = new boolean[n][n];

		// All substrings of length 1 are palindromes
		int maxLength = 1;
		for (int i = 0; i < n; ++i)
			table[i][i] = true;

		// check for sub-string of length 2.
		int start = 0;
		for (int i = 0; i < n - 1; ++i) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}

		// Check for lengths greater than 2. k is length
		// of substring
		for (int k = 3; k <= n; ++k) {

			// Fix the starting index
			for (int i = 0; i < n - k + 1; ++i) {
				// Get the ending index of substring from
				// starting index i and length k
				int j = i + k - 1;

				// checking for sub-string from ith index to
				// jth index iff str.charAt(i+1) to
				// str.charAt(j-1) is a palindrome
				if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
					table[i][j] = true;

					if (k > maxLength) {
						start = i;
						maxLength = k;
					}
				}
			}
		}
		System.out.print("Longest palindrome substring is; ");
		printSubStr(str, start, start + maxLength - 1);

		return maxLength; // return length of LPS
	}

	 public static String longestPalindromes(String s) {
	        int len = s.length();
	        int lps = 0;
	        int start = 1,end = len;
	        int max = 1;
	        while(start<=end){
	            
	            //odd
	            int i=start-1,j=start+1;
	            while(i>=0 && j<len && s.charAt(i) == s.charAt(j)){	                
	                if(j-i+1 > max){
	                    max = j-i+1;
	                    lps = i;
	                }                
	                i--;
	                j++;
	            }
	            
	            //even
	            i = start -1;
	            j = start;
	            while(i>=0 && j<len && s.charAt(i)==s.charAt(j)){	              
	                if(j-i+1 > max){
	                    max = j-i+1;
	                    lps = i;
	                }
	                i--;
	                j++;
	            }
	            start++;
	        }
	        return s.substring(lps,lps+max);
	    }
}