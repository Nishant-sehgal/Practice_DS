package com.hackerrank.dailycodeproblem;

public class Day12ClimbStarircase {

	public static void main(String[] args) {

		int N = 7;
		System.out.println(waysDp(N, new int[N + 1]));
		System.out.println(ways(N));
		System.out.println(ways(N, new int[] { 1, 2, 3 }));
		System.out.println(waysDp(N, new int[] { 1, 2, 3 }, new int[N + 1]));
	}

	// can take 2 steps
	public static int ways(int totalSteps) {
		if (totalSteps == 1 || totalSteps == 0) {
			return 1;
		}
		return ways(totalSteps - 1) + ways(totalSteps - 2);
	}

	// dp solution can take 2 steps
	public static int waysDp(int totalSteps, int[] dp) {
		if (totalSteps == 1 || totalSteps == 0) {
			dp[totalSteps] = 1;
			return dp[totalSteps];
		}
		if (dp[totalSteps] != 0) {
			return dp[totalSteps];
		}
		int val = waysDp(totalSteps - 1, dp) + waysDp(totalSteps - 2, dp);
		dp[totalSteps] = val;
		return val;
	}

	// can take variable allowed steps
	public static int ways(int totalSteps, int[] noOfStepsAllowed) {
		if (noOfStepsAllowed[0] == totalSteps || totalSteps == 0) {
			return 1;
		}

		int ways = 0;
		for (int i = 0; i < noOfStepsAllowed.length; i++) {
			int val = totalSteps - noOfStepsAllowed[i];
			if (val >= 0) {
				ways += ways(val, noOfStepsAllowed);
			}
		}
		return ways;
	}

	public static int waysDp(int totalSteps, int[] noOfStepsAllowed, int[] dp) {
		if (noOfStepsAllowed[0] == totalSteps || totalSteps == 0) {
			dp[totalSteps] = 1;
			return dp[totalSteps];
		}

		int ways = 0;
		for (int i = 0; i < noOfStepsAllowed.length; i++) {
			int val = totalSteps - noOfStepsAllowed[i];
			if (val >= 0) {
				ways += ways(val, noOfStepsAllowed);
			}
		}
		dp[totalSteps] = ways;
		return ways;
	}

}
