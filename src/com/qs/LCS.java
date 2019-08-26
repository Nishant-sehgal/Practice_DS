package com.qs;

import java.util.List;

public class LCS {

	public static void main(String[] args) {
		System.out.println(countSum(1));
	}

	public static int playlist(List<String> songs, int k, String q) {
		// Write your code here

		int ind = 0, indr = 0;
		for (int i = k; i < songs.size(); i++) {
			if (i + 1 == songs.size()) {
				i = 0;
			}
			if (songs.get(i).equals(q)) {
				break;
			}
			ind++;
		}

		for (int i = k; i >= 0; i--) {
			if (i == 0) {
				i = songs.size() - 1;
			}
			if (songs.get(i).equals(q)) {
				break;
			}
			ind++;
		}

		return Math.min(ind, indr);

	}

	public static int minMoves(List<Integer> avg) {
		int n = avg.size();
		int ones = 0;
		for (int i = 0; i < n; i++) {
			if (avg.get(i) == 1)
				ones++;
		}
		int x = ones;
		int currOnesCount = 0, maxOnes;
		for (int i = 0; i < x; i++) {
			if (avg.get(i) == 1)
				currOnesCount++;
		}
		maxOnes = currOnesCount;
		for (int i = 1; i <= n - x; i++) {
			if (avg.get(i - 1) == 1) {
				currOnesCount--;
			}
			if (avg.get(i + x - 1) == 1) {
				currOnesCount++;
			}

			if (maxOnes < currOnesCount) {
				maxOnes = currOnesCount;
			}
		}

		return x - maxOnes;

	}

	static int minSwaps(int arr[], int n) {

		int ones = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 1)
				ones++;
		}
		int x = ones;
		int currOnesCount = 0, maxOnes;
		for (int i = 0; i < x; i++) {
			if (arr[i] == 1)
				currOnesCount++;
		}
		maxOnes = currOnesCount;
		for (int i = 1; i <= n - x; i++) {
			if (arr[i - 1] == 1) {
				currOnesCount--;
			}
			if (arr[i + x - 1] == 1) {
				currOnesCount++;
			}

			if (maxOnes < currOnesCount) {
				maxOnes = currOnesCount;
			}
		}

		return x - maxOnes;
	}

	public static long countSum(Integer n) {
		int res = 1;

		while (n % 2 == 0)
			n = n / 2;

		for (int i = 3; i <= Math.sqrt(n); i++) {

			int curr_sum = 1;
			int curr_term = 1;
			while (n % i == 0) {

				n = n / i;

				curr_term *= i;
				curr_sum += curr_term;
			}

			res *= curr_sum;

		}

		if (n >= 2)
			res *= (1 + n);

		return res;
	}

	static int lcsDP(String s1, String s2, int s1length, int s2length) {

		int[][] lcsArray = new int[s1length + 1][s2length + 1];

		for (int i = 1; i <= s1length; i++) {
			for (int j = 1; j <= s2length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					lcsArray[i][j] = 1 + lcsArray[i - 1][j - 1];
				} else {
					lcsArray[i][j] = max(lcsArray[i][j - 1], lcsArray[i - 1][j]);
				}
			}
		}

		printlcs(lcsArray, s1length, s2length, s1, s2);
		return lcsArray[s1length][s2length];
	}

	static void printlcs(int[][] lcsArray, int m, int n, String s1, String s2) {
		while (m > 0 && n > 0) {
			if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
				System.out.print(s1.charAt(m - 1));
				m--;
				n--;
			} else {
				if (lcsArray[m - 1][n] > lcsArray[m][n - 1]) {
					m--;
				} else {
					n--;
				}
			}

		}
		System.out.println();
	}

	static int lcs(String s1, String s2, int s1length, int s2length) {
		if (s1length == 0 || s2length == 0) {
			return 0;
		}

		if (s1.charAt(s1length - 1) == s2.charAt(s2length - 1)) {
			return 1 + lcs(s1, s2, s1length - 1, s2length - 1);
		} else {
			return max(lcs(s1, s2, s1length - 1, s2length), lcs(s1, s2, s1length, s2length - 1));
		}
	}

	static int max(int i, int j) {
		return i > j ? i : j;
	}
}
