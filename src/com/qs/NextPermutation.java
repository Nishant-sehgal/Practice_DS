package com.qs;	

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		nextPermutation(new int[] { 2,1,8,7,6,5 });
	}

	public static void nextPermutation(int[] nums) {
		if (null == nums || nums.length == 0) {
			return;
		}
		int start = 0;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				start = i - 1;
				break;
			}
		}
		int largeIndex = start;
		int greater = Integer.MAX_VALUE;
		for (int m = start + 1; m < nums.length; m++) {
			if (nums[m] > nums[start] && greater > nums[m]) {
				largeIndex = m;
				greater = nums[m];
			}
		}
		if (start == largeIndex) {
			int k = 0, j = nums.length - 1;
			while (k <= j) {
				int temp = nums[k];
				nums[k] = nums[j];
				nums[j] = temp;
				k++;
				j--;
			}
		} else {			

			int temp1 = nums[largeIndex];
			nums[largeIndex] = nums[start];
			nums[start] = temp1;

			Arrays.sort(nums, start + 1, nums.length);
		}

	}
}
