package com.amazon.qs;

public class BinarySearchOccurence {

	public static void main(String[] args) {
		System.out.println(bs(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 7, 5));
		System.out.println(occurence(new int[] { 0, 1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 6, 7 }, 14, 3));
	}

	public static boolean bs(int[] arr, int length, int element) {
		int beg = 0;
		int end = length - 1;
		while (beg <= end) {
			int mid = beg + (end - beg) / 2;
			if (arr[mid] == element) {
				return true;
			}

			if (arr[mid] > element) {
				end = mid - 1;
			} else {
				beg = mid + 1;
			}
		}
		return false;
	}

	/*
	 * Count number of occurrences (or frequency) in a sorted array
	 */

	public static int occurence(int[] arr, int length, int element) {
		int i = first(arr, length, element);
		int j = 0;
		if (i != -1) {
			j = last(arr, length, element);
			return j-i+1;
		}
		return -1;
	}

	public static int first(int[] arr, int length, int element) {
		int beg = 0;
		int end = length - 1;
		while (beg <= end) {
			int mid = beg + (end - beg) / 2;

			if (mid == 0 || (arr[mid - 1] < element && arr[mid] == element)) {
				return mid;
			}

			if (arr[mid] < element) {
				beg = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static int last(int[] arr, int length, int element) {
		int beg = 0;
		int end = length - 1;
		while (beg <= end) {
			int mid = beg + (end - beg) / 2;

			if (mid == length-1 || (arr[mid + 1] > element && arr[mid] == element)) {
				return mid;
			}

			if (arr[mid] > element) {
				end = mid - 1;
			} else {
				beg = mid + 1;
			}
		}
		return -1;
	}
}
