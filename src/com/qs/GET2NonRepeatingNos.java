package com.qs;

public class GET2NonRepeatingNos {

	static void get2NonRepeatingNos(int arr[], int n, int x, int y) {
		int xor = arr[0]; /* Will hold xor of all elements */
		int set_bit_no; /* Will have only single set bit of xor */
		int i;

		/* Get the xor of all elements */
		for (i = 1; i < n; i++)
			xor ^= arr[i];

		/* Get the rightmost set bit in set_bit_no */
		set_bit_no = xor & ~(xor - 1);

		/*
		 * Now divide elements in two sets by comparing rightmost set bit of xor
		 * with bit at same position in each element.
		 */
		for (i = 0; i < n; i++) {
			if ((arr[i] & set_bit_no) != 0)
				x = x ^ arr[i]; /* XOR of first set */
			else
				y = y ^ arr[i]; /* XOR of second set */
		}
		System.out.println(x + " and " + y);
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		int x = 0, y = 0;

		int arr[] = { 2, 3, 7, 9, 11, 2, 3, 11 };

		get2NonRepeatingNos(arr, 8, x, y);

	}
}