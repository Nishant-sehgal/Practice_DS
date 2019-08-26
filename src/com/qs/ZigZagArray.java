package com.qs;

import java.util.Arrays;

public class ZigZagArray {

	public static void main(String[] args) {
		zigZag(new int[] { 1, 4, 3, 2 });
	}

	public static void zigZag(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			if (i % 2 == 0) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			} else {
				if (arr[i] < arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}

		Arrays.stream(arr).forEach(val -> {
			System.out.print(val + ",");
		});
		System.out.println();
	}

	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
