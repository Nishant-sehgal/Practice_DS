package hackerrank.graph.subestcomponent;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	private static int MAX_BITS = 64;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		int[] inputArray = new int[q];
		for (int i = 0; i < q; i++) {
			inputArray[i] = in.nextInt();
		}
		System.err.println(calculateSubset(inputArray, q));
		in.close();
	}

	public static int calculateSubset(int[] subsetArray, int n) {
		Set<String> subsetSet = new HashSet<>();
		for (int i = 0; i < (1 << n); i++) {
			String str = "";
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0)
					str += subsetArray[j] + ",";
			}
			if (str != "") {
				subsetSet.add(str.substring(0, str.length() - 1));
			} else {
				subsetSet.add("");
			}
		}
		int totalCount = 0;
		for (String setValues : subsetSet) {
			totalCount += getConnectedCount(setValues);
		}
		return totalCount;
	}

	public static int getConnectedCount(String s) {
		Set<Integer> set = new HashSet<>();
		String[] strArray = s.split(",");
		if (s == "") {
			System.out.println(MAX_BITS);
			return MAX_BITS;
		}
		for (int str = 0; str < strArray.length; str++) {
			int val = Integer.parseInt(strArray[str]);
			StringBuilder binaryNumber = new StringBuilder("");
			while (val != 0) {
				binaryNumber.append(val % 2);
				val = val / 2;
			}
			returnSetwithPosition(binaryNumber.reverse().toString(), set);
		}
		System.out.println(MAX_BITS - (set.size() - 1));
		return MAX_BITS - (set.size() - 1);
	}

	public static void returnSetwithPosition(String number, Set<Integer> set) {
		int count = 0;
		for (int i = number.length()-1; i >= 0; i--) {
			if (number.charAt(i) == '1' && !set.contains(count)) {
				set.add(count);
			}
			count++;
		}
	}
}
