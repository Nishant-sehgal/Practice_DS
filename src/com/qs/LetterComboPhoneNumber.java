package com.qs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterComboPhoneNumber {

	public static void main(String[] args) {
		letterCombinations("23");

	}

	public static List<String> letterCombinations(String digits) {
		Map<String, List<String>> map = new HashMap<>();
		map.put("2", Arrays.asList("a", "b", "c"));
		map.put("3", Arrays.asList("d", "e", "f"));
		map.put("4", Arrays.asList("g", "h", "i"));
		map.put("5", Arrays.asList("j", "k", "l"));
		map.put("6", Arrays.asList("m", "n", "o"));
		map.put("7", Arrays.asList("p", "q", "r", "s"));
		map.put("8", Arrays.asList("t", "u", "v"));
		map.put("9", Arrays.asList("w", "x", "y", "z"));
		List<String> list = new ArrayList<>();
		test(digits, map, "", list);
		return list;
	}

	public static void test(String digits, Map<String, List<String>> map, String str, List<String> list) {
		if (digits.equals("")) {
			list.add(str);
			return;
		}
		List<String> val = map.get(digits.charAt(0) + "");
		for (int j = 0; j < val.size(); j++) {
			test(digits.substring(1, digits.length()), map, str + val.get(j), list);
		}
	}
}
