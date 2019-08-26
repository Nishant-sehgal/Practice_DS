package com.hackerrank.dailycodeproblem;

import java.util.Arrays;

public class Day2ProductArray {

	public static void main(String[] args) {

		// 120,60,40,30,24
		Arrays.stream(productArray(new int[] { 1, 2, 3, 4, 5 })).forEach(i -> {
			System.out.print(i + "\t");
		});
		System.out.println();
		System.out.println("**************************");
		// 24,60,40,30,120
		Arrays.stream(productArray(new int[] { 5, 2, 3, 4, 1 })).forEach(i -> {
			System.out.print(i + "\t");
		});
		System.out.println();
		System.out.println("**************************");
		// 192,480,320,240,120
		Arrays.stream(productArray(new int[] { 5, 2, 3, 4, 8 })).forEach(i -> {
			System.out.print(i + "\t");
		});
	}

	public static int[] productArray(int[] arr) {
		int[] newArray = new int[arr.length];
		int leftProd = 1, rightProd = 1;
		for (int k = 0; k < arr.length; k++) {
			if (k == 0) {
				leftProd = arr[k];
				newArray[k] = 1;
			} else {
				newArray[k] = leftProd;
				leftProd *= arr[k];
			}

		}
		/*
		 * Arrays.stream(newArray).forEach(i -> { System.out.print(i + "\t");
		 * }); System.out.println();
		 */
		for (int k = arr.length - 1; k >= 0; k--) {
			if (k == arr.length - 1) {
				rightProd = arr[k];
			} else {
				newArray[k] *= rightProd;
				rightProd *= arr[k];
			}

		}

		return newArray;
	}
}
