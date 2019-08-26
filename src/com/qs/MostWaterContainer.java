package com.qs;

public class MostWaterContainer {

	public static void main(String[] args) {
		maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
	}

	public static int maxArea(int[] height) {
		int[] leftArr = new int[height.length];
		int[] rightArr = new int[height.length];

		leftArr[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			leftArr[i] = Math.max(height[i], leftArr[i - 1]);
		}

		rightArr[height.length - 1] = height[height.length - 1];
		for (int j = height.length - 2; j >= 0; j--) {
			rightArr[j] = Math.max(height[j], rightArr[j + 1]);
		}
		int start = 0;
		int end = height.length - 1;
		int max = 0;
		while (start < end) {
			int val = Math.min(leftArr[start], rightArr[end]);
			max = Math.max(max, val * (end - start));
			if (rightArr[end] < leftArr[start]) {
				end--;
			} else {
				start++;
			}
		}
		return max;
	}
}
