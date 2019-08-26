package com.qs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TrainAndPlatform {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Integer> arrival = new ArrayList<>();
		List<Integer> departure = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arrival.add(in.nextInt());
			departure.add(in.nextInt());
		}
		in.close();
		System.out.println(cal(arrival, departure));
	}

	private static int cal(List<Integer> arrival, List<Integer> departure) {
		int plat_needed = 1;
		int result = 1;
		int i = 1, j = 0;
		int n = arrival.size();
		Collections.sort(arrival);
		Collections.sort(departure);
		while (i < n && j < n) {
			if (arrival.get(i) <= departure.get(j)) {
				plat_needed++;
				i++;

				if (plat_needed > result)
					result = plat_needed;
			}

			else {
				plat_needed--;
				j++;
			}
		}

		return result;
	}

}
