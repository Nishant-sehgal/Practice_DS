package com.hackerrank.dailycodeproblem;

public class Day7NumberOfWaysOfDecoded {

	public static void main(String[] args) {
		decodeCount("1626", "", 0, 3);
		System.out.println(count);
		System.out.println("*********");
		count = 0;
		decodeCount("111", "", 0, 2);
		System.out.println(count);
		System.out.println("*********");
		count = 0;
		decodeCount("333", "", 0, 2);
		System.out.println(count);
		System.out.println("*********");
		count = 0;
		decodeCount("12345", "", 0, 4);
		System.out.println(count);
		System.out.println("*********");
	}

	private static int count = 0;

	public static void decodeCount(String input, String str, int start, int end) {
		if (start <= end) {
			decodeCount(input, str += input.charAt(start) + ",", start + 1, end);
			if (start > end || (start + 1) > end) {
				return;
			}
			str = str.substring(0, str.length() - 2);
			int val = Integer.parseInt(input.charAt(start) + "" + input.charAt(start + 1) + "");
			if (val <= 26) {
				decodeCount(input, str += val + ",", start = start + 2, end);
				str = str.substring(0, str.length() - 3);
				return;
			} else {
				return;
			}
		}
		count++;
		str = str.substring(0, str.length() - 1);
		System.out.println(str);
		str += "";
		return;
	}
}
