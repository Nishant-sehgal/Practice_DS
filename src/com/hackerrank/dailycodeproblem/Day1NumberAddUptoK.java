package com.hackerrank.dailycodeproblem;

import java.util.HashSet;
import java.util.Set;

public class Day1NumberAddUptoK {

	public static void main(String[] args) {
		System.out.println(findSumExist(new int[] { 1, 2, 10, 5, 7 }, 4));
		System.out.println(findSumExist(new int[] { 4, 4, 2, 10, 5, 7 }, 8));
		System.out.println(findSumExist(new int[] { -1, 2, 27, 5, -10 }, 17));
		System.out.println(findSumExist(new int[] { -1, -2, -3, -7, -10 }, -17));
		System.out.println(findSumExist(new int[] { 10, 15, 3, 7 }, 17));
	}

	public static boolean findSumExist(int[] arr, int sum) {
		Set<Integer> numbersSet = new HashSet<>();

		for (int i : arr) {
			if (numbersSet.contains(sum - i)) {
				return true;
			}
			numbersSet.add(i);
		}
		return false;
	}
}
