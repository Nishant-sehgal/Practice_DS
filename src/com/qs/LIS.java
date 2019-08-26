package com.qs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LIS {
	private static int max = 1;

	//10, 22, 9, 33, 21, 50, 41, 60, 80
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*lis(new int[] { 50, 3, 10, 7, 40, 80 }, 6);
		System.out.println(max);*/
		lisDP(new int[] { 50, 3, 10, 7, 40, 80 }, 6);
	}

	public static int lis(int[] arr, int end) {
		int res = 1, count = 1;
		if (end == 1) {
			return 1;
		}
		for (int i = 1; i < end; i++) {
			res = lis(arr, i);
			if (arr[i - 1] < arr[end - 1] && res + 1 > count) {
				count = res + 1;
			}
		}
		if (count > max) {
			max = count;
		}
		return count;
	}

	public static void lisDP(int[] arr, int end) {
		/*
		 * Map<Integer, List<Integer>> map = new HashMap<>(); List<Integer> l =
		 * new ArrayList<>(); l.add(arr[0]); map.put(0, l);
		 */
		int[] lis = new int[end];

		for (int i = 0; i < end; i++) {
			lis[i] = 1;
		}
		for (int i = 1; i < end; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[j] + 1 > lis[i]) {
					lis[i] = lis[j] + 1;
					// putInMapOtherArray(i, j, map);
				}
			}
			// putInMap(i, arr[i], map);
		}
		System.out.println(lis[end - 1]);
		printLis(lis, arr);
	}

	private static void printLis(int[] lis, int[] arr) {
		int length = lis.length - 1;
		int val = lis[length];
		for (int i = length; i >= 0; i--) {
			if (val == lis[i]) {
				System.out.print(arr[i] + "\t");
				val--;
			}

		}
	}

	public static void putInMapOtherArray(int i, int j, Map<Integer, List<Integer>> map) {
		List<Integer> l = new ArrayList<>();
		l.addAll(map.get(j));
		map.put(i, l);
	}

	public static void putInMap(int i, int arr, Map<Integer, List<Integer>> map) {
		if (map.containsKey(i)) {
			map.get(i).add(arr);

		} else {
			List<Integer> l = new ArrayList<>();
			l.add(arr);
			map.put(i, l);
		}
	}
}
