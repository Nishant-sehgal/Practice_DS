package com.qs;

public class MedianInTwoSortedArray {

	public static void main(String[] args) {

	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		if (nums1.length > nums2.length) {
			int temp[] = nums1;
			nums1 = nums2;
			nums2 = temp;
		}
		int start = 0;
		int end = nums1.length;
		int count = nums1.length + nums2.length;
		while (start <= end) {
			int partitionX = (start + nums1.length) / 2;
			int partitionY = ((nums1.length + nums2.length + 1) / 2) - partitionX;

			int maxXLeft = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = partitionX == nums1.length ? Integer.MAX_VALUE : nums1[partitionX];
			int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = partitionY == nums2.length ? Integer.MAX_VALUE : nums2[partitionY];
			if (maxXLeft <= minRightY && minRightX >= maxLeftY) {
				if (count % 2 == 0) {
					return (double)(Math.max(maxXLeft, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return Math.max(maxXLeft, maxLeftY);
				}
			} else if (maxXLeft > minRightY) {
				start = start - 1;
			} else {
				start = start + 1;
			}
		}

		return 0;
	}

}
