package com.qs;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		lengthOfLongestSubstring("tmmzuxt");
	}

	public static int lengthOfLongestSubstring(String s) {
		int windowCount = 0;
		int max = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))
					&& (null != map.get(s.charAt(i)) ? map.get(s.charAt(i)) : -1) >= windowCount) {
				windowCount = map.get(s.charAt(i)) + 1;
			} else {
				max = Math.max(max, i - windowCount + 1);
			}
			map.put(s.charAt(i), i);
		}
		return max;
	}

}
