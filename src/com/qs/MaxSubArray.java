package com.qs;

import java.util.HashMap;

public class MaxSubArray {

	public static void main(String[] args) {
		// 1,-1,1,1,1,-1,-1
		System.out.println(maxLen(new int[] {1, 0, 1, 1, 1, 0, 0}));
	}

	static int maxLen(int arr[]) {
		int start = 0, end = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = -1;
			}
		}
		// Creates an empty hashMap hM
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

		int sum = 0; // Initialize sum of elements
		int max_len = 0; // Initialize result

		// Traverse through the given array
		for (int i = 0; i < arr.length; i++) {
			// Add current element to sum
			sum += arr[i];

			if (arr[i] == 0 && max_len == 0)
				max_len = 1;

			if (sum == 0){
				start = 0;
				end = i;
				max_len = i + 1;
				continue;
			}

			// Look this sum in hash table
			Integer prev_i = hM.get(sum);

			// If this sum is seen before, then update max_len
			// if required
			if (prev_i != null) {
				max_len = Math.max(max_len, i - prev_i);
				end = i;
				start = prev_i+1;
			} else // Else put this sum in hash table
				hM.put(sum, i);
		}
		System.out.println("array :: "+start + " "+end);

		return max_len;
	}

}
