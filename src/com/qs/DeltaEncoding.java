package com.qs;

import java.util.ArrayList;
import java.util.List;

public class DeltaEncoding {

	public static void main(String[] args) {
	
		encode(new int[]{25626,25757,24367,24267,16,100,2,7277});

	}

	public static List<Integer> encode(int[] arr) {
		int escape = -128;
		List<Integer> encode = new ArrayList<>();
		if (arr.length == 1) {
			return new ArrayList<>(arr[0]);
		}
		int prev = arr[0];
		encode.add(prev);
		for (int i = 1; i < arr.length; i++) {
			int diff = arr[i] - prev;
			if (Math.abs(diff) > 127) {
				encode.add(escape);
			}
			encode.add(diff);
			prev = arr[i];
		}
		encode.forEach(val->{System.out.println(val);});
		return encode;
	}
}
