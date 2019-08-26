package com.program;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 6, 3, 4, 1, 2 };
		mergeSort(arr, 0, 5);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + "\t");
		}
	}

	public static void mergeSort(int[] arr, int low, int high) {
		if (high > low) {
			int mid = low + (high - low) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	public static void merge(int[] arr, int low, int mid, int high) {
		int length1 = mid - low + 1;
		int length2 = high - mid;
		int[] arr1 = new int[length1];
		int[] arr2 = new int[length2];
		for (int i = 0; i < length1; i++) {
			arr1[i] = arr[i + low];
		}
		for (int j = 0; j < length2; j++) {
			arr2[j] = arr[j + mid + 1];
		}
		int i = 0, j = 0;
		int k = low;
		while (length1 > i && length2 > j) {
			if (arr1[i] > arr2[j]) {
				arr[k++] = arr2[j++];
			} else {
				arr[k++] = arr1[i++];
			}
		}
		while (i < length1) {
			arr[k++] = arr1[i++];
		}
		while (j < length2) {
			arr[k++] = arr2[j++];
		}
	}
}
