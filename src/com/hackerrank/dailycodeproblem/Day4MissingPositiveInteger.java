package com.hackerrank.dailycodeproblem;

public class Day4MissingPositiveInteger {

	public static void main(String[] args) {
		// 2
		System.out.println(firstMissingPositive(new int[] { 3, 4, -1, 1 }));
		// 1
		System.out.println(firstMissingPositive(new int[] { 2, 3, 7, 6, 8, -1, -10, 15 }));
		// 4
		System.out.println(firstMissingPositive(new int[] { 2, 3, -7, 6, 8, 1, -10, 15 }));
		// 2
		System.out.println(firstMissingPositive(new int[] { 1, 1, 0, -1, -2 }));
		// 4
		System.out.println(firstMissingPositive(new int[] { 1, 2, 3 }));
		// 1
		System.out.println(firstMissingPositive(new int[] { 0, 2 }));
		// 1
		System.out.println(firstMissingPositive(new int[] { -1, -4 }));
		// 1
		System.out.println(firstMissingPositive(new int[] { 0, 0 }));
	}

	public static int firstMissingPositive(int[] arr) {
		int start = 0, end = arr.length - 1;
		while (start < end) {
			while (start < end && arr[start] > 0) {
				start++;
			}
			while (start <= end && arr[end] <= 0) {
				arr[end] = 0;
				end--;
			}
			if (start < end) {
				arr[start] = arr[end];
				arr[end] = 0;
				start++;
				end--;
			}
		}
		for (int i = 0; i <= end; i++) {
			int temp = Math.abs(arr[i]) - 1;
			if (temp >= 0 && temp <= arr.length - 1 && arr[temp] >= 0) {
				arr[temp] = -arr[temp];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0) {
				return i + 1;
			}
		}
		return arr.length + 1;
	}
}
