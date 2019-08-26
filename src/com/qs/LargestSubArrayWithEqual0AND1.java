package com.qs;

public class LargestSubArrayWithEqual0AND1 {

	public static void main(String[] args) {
		maxSubArray(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});
	}

	public static void maxSubArray(int[] arr) {
		int max_ending_here = 0, max_so_far = 0, start = 0, end = 0;

		for (int i = 0; i < arr.length; i++) {

			max_ending_here += arr[i];

			if (max_ending_here > max_so_far) {
				max_so_far = max_ending_here;
				end = i;
			}

			if (max_ending_here < 0) {
				max_ending_here = 0;
				start = i+1;
			}
		}
		System.out.println(max_so_far);
		System.out.println("Array vaue:: " + start + " " + end);

	}

}
