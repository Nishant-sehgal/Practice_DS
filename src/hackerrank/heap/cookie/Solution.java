package hackerrank.heap.cookie;

import java.util.Scanner;

public class Solution {

	private static int[] arr;
	private static int length = 0;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		arr = new int[size + 1];
		int cookieVal = scn.nextInt();
		for (int i = 0; i < size; i++) {
			int val = scn.nextInt();
			add(val);
		}
		System.out.println(checkCookie(cookieVal));
		scn.close();
	}

	public static int checkCookie(int cookieVal) {
		int operation = 0;
		while (length >= 1) {
			if (length == 1 && arr[1] < cookieVal) {
				operation = -1;
				break;
			}
			int val1 = arr[1];
			if (val1 >= cookieVal) {
				break;
			}
			delete(val1);
			int val2 = arr[1];
			delete(val2);
			int newCookie = (1 * val1) + (2 * val2);
			operation++;
			add(newCookie);
			int neMinVal = arr[1];
			if (neMinVal >= cookieVal) {
				break;
			}

		}
		return operation;
	}

	public static void add(int val) {
		arr[++length] = val;
		upheap(arr, length);
		// System.out.println("Add : "+Arrays.toString(arr));
	}

	public static void upheap(int[] arr, int start) {
		if (start > 1) {
			int parent = start / 2;
			if (arr[start] < arr[parent]) {
				int temp = arr[parent];
				arr[parent] = arr[start];
				arr[start] = temp;
				upheap(arr, parent);
			}
		}
	}

	public static void delete(int val) {
		int start = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == val) {
				arr[i] = arr[length];
				arr[length] = 0;
				length--;
				start = i;
				break;
			}
		}
		/*
		 * for (int i = start; i <= counter; i++) { upheap(arr, i); }
		 */

		downheap(arr, start);
		// System.out.println("Delete : "+Arrays.toString(arr));
	}

	public static void downheap(int[] arr, int start) {
		if (start <= length) {
			int left = 2 * start;
			int right = left + 1;
			int temp = arr[start];
			if (left <= length) {
				int min = arr[left];
				int index = left;
				if (right <= length) {
					if (arr[right] < min) {
						min = arr[right];
						index = right;
					}
				}
				if (arr[start] > arr[index]) {
					arr[start] = arr[index];
					arr[index] = temp;
					downheap(arr, index);
				}
			}
		}
	}
}
