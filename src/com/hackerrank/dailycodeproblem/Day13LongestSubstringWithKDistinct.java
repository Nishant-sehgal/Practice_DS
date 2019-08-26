package com.hackerrank.dailycodeproblem;

import java.util.HashMap;
import java.util.Map;

public class Day13LongestSubstringWithKDistinct {

	public static void main(String[] args) {
		System.out.println(longestSubstr("abbbbbcba", 2));
		System.out.println(longestSubstr("abbbbbcba", 3));
		System.out.println(longestSubstr("aaabbbbbcccccccbba", 2));
		System.out.println(longestSubstr("abcba", 2));
	}

	public static String longestSubstr(String inputStr, int k) {

		int start = 0;
		int max = 0;
		int beg = 0, end = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < inputStr.length(); i++) {
			if (map.get(inputStr.charAt(i)) != null) {
				map.put(inputStr.charAt(i), map.get(inputStr.charAt(i)) + 1);
			} else {
				map.put(inputStr.charAt(i), 1);
			}
			if (map.size() == k) {
				if (i - start >= max) {
					max = i - start;
					beg = start;
					end = i;
				}
			} else if (map.size() > k) {
				int val = map.get(inputStr.charAt(start));
				if (val > 1) {
					map.put(inputStr.charAt(start), map.get(inputStr.charAt(start)) - 1);
				} else {
					map.remove(inputStr.charAt(start));
				}
				start++;
			}
		}
		return inputStr.substring(beg, end+1);
	}
}
