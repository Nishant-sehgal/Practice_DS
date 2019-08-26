package com.qs;

import java.util.Map;
import java.util.TreeMap;

public class MissingNumbers {

	public static void main(String[] args) {
		missingNumbers(new int[] {203,204,205,206,207,208,203,204,205,206}, new int[] {203,204,204,205,206,207,205,208,203,206,205,206,204});
	}

	static int[] missingNumbers(int[] arr, int[] brr) {
		Map<Integer, Integer> map = new TreeMap<>();

		for (int i = 0; i < brr.length; i++) {
			if (map.containsKey(brr[i])) {
				map.put(brr[i], map.get(brr[i]) + 1);
			} else {
				map.put(brr[i], 1);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				int val = map.get(arr[i]) - 1;
				if (val == 0) {
					map.remove(arr[i]);
				} else {
					map.put(arr[i], val);
				}
			}
		}
		return map.keySet().stream().mapToInt(i -> i).toArray();
	}
}
