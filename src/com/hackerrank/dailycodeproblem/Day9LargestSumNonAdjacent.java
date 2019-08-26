package com.hackerrank.dailycodeproblem;

public class Day9LargestSumNonAdjacent {

	public static void main(String[] args) {
		System.out.println(findLargestSum(new int[] { 2, 4, 6, 2, 5 }));
		System.out.println(findLargestSum(new int[] { 5, 1, 1, 5 }));
		System.out.println(findLargestSum(new int[] { 6, 7, 1, 3, 8, 2, 4 }));
		System.out.println(findLargestSum(new int[] { 5, 3, 4, 11, 2 }));
		System.out.println(findLargestSum(new int[] { 5, 3 }));
	}

	public static int findLargestSum(int[] arr) {

		int sum1 = arr[0];
		int sum2 = Math.max(arr[0], arr[1]);

		for (int i = 2; i < arr.length; i++) {
			int temp = Math.max(sum1 + arr[i], sum2);
			sum1 = Math.max(sum1, sum2);
			sum2 = temp;

		}
		return sum2;
	}
}
