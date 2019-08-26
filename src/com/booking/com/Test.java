package com.booking.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	static Set<String> wordsToSearch = new HashSet<String>();

	static Map<Integer, Integer> hotels = new HashMap<Integer, Integer>();

	private static void fillWordsToSearch(String[] words) {
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			// Add to our HashSet
			wordsToSearch.add(word.toLowerCase());
		}
	}

	private static void fillHotels(String[] reviews, int[] hotel_ids) {
		for (int i = 0; i <= hotel_ids.length; i++) {
			int hotelId = hotel_ids[i];
			int hotelReviews = countWords(reviews[i]);
			hotels.put(hotelId, hotelReviews);
		}
	}

	private static Map<Integer, Integer> sortHotelsByReviews(final Map<Integer, Integer> map) {
		Comparator<Integer> valueComparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer k1, Integer k2) {
				int compare = map.get(k2).compareTo(map.get(k1));
				if (compare == 0)
					return 1;
				else
					return compare;
			}
		};
		Map<Integer, Integer> sortedByValues = new TreeMap<Integer, Integer>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}

	private static int[] showHotelList() {
		Map<Integer, Integer> sortedHotels = sortHotelsByReviews(hotels);
		int[] hotel = new int[sortedHotels.size()];
		int counter = 0;
		for (Integer hotelId : sortedHotels.keySet()) {
			hotel[counter++] = hotelId;
		}
		return hotel;
	}

	private static int countWords(String review) {
		int counter = 0;
		for (String word : wordsToSearch) {
			Pattern pattern = Pattern.compile(word);
			Matcher matcher = pattern.matcher(review.toLowerCase());
			while (matcher.find()) {
				counter++;
			}
		}
		return counter;
	}

	static int[] sort_hotels(String keywords, int[] hotel_ids, String[] reviews) {
		fillWordsToSearch(keywords.split(" "));
		fillHotels(reviews, hotel_ids);
		return showHotelList();
	}

	/*
	 * static int howManyAgentsToAdd(int noOfCurrentAgents, int[][] callsTimes)
	 * {
	 *
	 * }
	 */
	static int[] delta_encode(int[] array) {
		List<Integer> list = new ArrayList<>();
		list.add(array[0]);
		for (int i = 1; i < array.length; i++) {
			int val = array[i] - array[i - 1];
			if (val > 128 || val < -128) {
				list.add(-128);
			}
			list.add(val);
		}
		int[] temp = new int[list.size()];
		int count = 0;
		for (Integer val : list) {
			temp[count++] = val;
		}
		return temp;

	}

	static int polygon(int a, int b, int c, int d) {
		if (a < 0 || b < 0 || c < 0 || d < 0) {
			return 0;
		}
		if (a == b && a == c && a == d) {
			return 2;
		} else if (a == c && b == d) {
			if (c * c + b * b == a * a + d * d) {
				return 1;
			}
			return 0;
		} else {
			return 0;
		}
	}

	static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}

	}

	static int howManyAgentsToAdd(int noOfCurrentAgents, int[][] callsTimes) {
		Stack<Interval> stack = new Stack<>();
		int[][] arr = callsTimes;
		Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

		stack.push(new Interval(arr[0][0], arr[0][1]));

		for (int i = 1; i < arr.length; i++) {
			Interval top = stack.peek();
			if (top.end < arr[i][0])
				stack.push(new Interval(arr[i][0], arr[i][1]));

			else if (top.end < arr[i][1]) {
				stack.pop();
				stack.push(top);
			}
		}

		System.out.println(stack);

		return stack.size() - noOfCurrentAgents;
	}
	/*
	 * private boolean checkSquare(int d1, int d2, int d3, int d4){ if (d2 == d3
	 * && 2*d2 == d4) { int d = distSq(d2, d4); return (d == distSq(d3, d4) && d
	 * == d2); }
	 *
	 * // The below two cases are similar to above case if (d3 == d4 && 2*d3 ==
	 * d2) { int d = distSq(d2, d3); return (d == distSq(d2, d4) && d == d3); }
	 * if (d2 == d4 && 2*d2 == d3) { int d = distSq(d2, d3); return (d ==
	 * distSq(d3, d4) && d == d2); } return false; } int distSq(int p, int q) {
	 * return ; }
	 */
}
