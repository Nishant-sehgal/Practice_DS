package com.bankbazar;

import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMaxOccurrences("ababab", 2, 3, 4));
		//System.out.println(getIntegerComplement(100));
	}

	/*static int getIntegerComplement(int n) {

		int x = Integer.highestOneBit(n);

		int c= 0;
		int no = 0;
		while(no < x) {
			no += Math.pow(2, c);
			c++;
		}
		return n^no;
    }
*/
	static int getMaxOccurrences(String s, int minLength, int maxLength, int maxUnique) {
		int occ = 0;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = minLength; j <= maxLength && i + j <= s.length(); j++) {
				String sub = s.substring(i, i + j);
				if (getUnique(sub) > maxUnique) {
					continue;
				}
				if (map.containsKey(sub)) {
					map.put(sub, map.get(sub) + 1);
				} else {
					map.put(sub, 1);
				}

				if (map.containsKey(sub) && map.get(sub) > occ) {
					occ = map.get(sub);
				}
			}
		}

		return occ;
	}

	private static int getUnique(String input) {

		return (int) input.chars().distinct().count();
	}

}
