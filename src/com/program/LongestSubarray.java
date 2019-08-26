package com.program;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubarray {

	public static void main(String[] args) {
		int arr1[] = { 8,7,6,5,4,1,2};
		// 1,3,4,2
		System.out.println(findLongestConseqSubseq(arr1, 7));
	}

	// 1,2,3,4,9,10,20
	public static int longestSubArray(int[] arr, int length) {

		/*
		 * int[] temArr = new int[100]; int max = 0; int maxSoFar = 0; for (int
		 * i = 0; i < arr.length; i++) { temArr[arr[i]] = 1; } for (int i = 0; i
		 * < temArr.length; i++) { if (temArr[i] == 1) { max++; if (maxSoFar <
		 * max) { maxSoFar = max; } } else { max = 0; } } return max;
		 */
		int max = 0;
		int maxSoFar = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], arr[i] + 1);
		}
		Set<Integer> keys = map.keySet();
		for (Integer number : keys) {
			Integer temp = map.get(number);
			while (temp != null) {
				temp = map.get(temp);
				max++;
				if (maxSoFar < max) {
					maxSoFar = max;
				}
			}
			max = 0;
		}
		return maxSoFar;
	}

	static int findLongestConseqSubseq(int arr[], int n) {
		HashSet<Integer> S = new HashSet<Integer>();
		int ans = 0;

		// Hash all the array elements
		for (int i = 0; i < n; ++i)
			S.add(arr[i]);

		// check each possible sequence from the start
		// then update optimal length
		for (int i = 0; i < n; ++i) {
			// if current element is the starting
			// element of a sequence
			if (!S.contains(arr[i] - 1)) {
				// Then check for next elements in the
				// sequence
				int j = arr[i];
				while (S.contains(j))
					j++;

				// update optimal length if this length
				// is more
				if (ans < j - arr[i])
					ans = j - arr[i];
			}
		}
		return ans;
	}

}
