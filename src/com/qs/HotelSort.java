package com.qs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HotelSort {

	public static void main(String[] args){
		List<Integer> hotel_ids	= new ArrayList<Integer>();
		hotel_ids.add(0,2);
		hotel_ids.add(1,1);
		hotel_ids.add(2,2);
		List<String> reviews	= new ArrayList<String>();
		reviews.add(0,"location is mukesh.") ;
		reviews.add(1,"is new xyz.");
		reviews.add(2,"pto. is");
		List<Integer> res = sort_hotels("mukesh kumar xyz kmn pto..",hotel_ids,reviews);
		for(int i=0;i<res.size();i++){
			System.out.println("id := "+res.get(i));
		}
	}
	// Complete the sort_hotels function below.
	static List<Integer> sort_hotels(String keywords, List<Integer> hotel_ids, List<String> reviews) {
		keywords = cleanText(keywords);
		String[] keywordsList = keywords.split(" ");
		Set<String> keywordsMap = new HashSet<>();
		for (String word : keywordsList) {
			keywordsMap.add(word.toUpperCase().trim());
		}
		Map<Integer, Integer> hotelIdMap = new HashMap<>();
		for (Integer id : hotel_ids) {
			hotelIdMap.put(id, 0);
		}
		for (int i = 0; i < reviews.size(); i++) {
			hotelIdMap.put(hotel_ids.get(i),
					hotelIdMap.get(hotel_ids.get(i)) + findRating(reviews.get(i), keywordsMap));
		}
		return sortByValue(hotelIdMap);
	}

	private static Integer findRating(String text, Set<String> keysMap) {
		text = cleanText(text);
		String[] keys = text.split(" ");
		Integer c = 0;
		for (String string : keys) {
			if (keysMap.contains(string.toUpperCase())) {
				c++;
			}
		}
		return c;
	}

	private static String cleanText(String text) {
		char[] res = new char[text.length()];
		int j = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '.' || text.charAt(i) == ',' || text.charAt(i) == '!' || text.charAt(i) == '\n') {
				continue;
			}
			res[j++] = text.charAt(i);
		}
		return new String(res);
	}

	private static List<Integer> sortByValue(Map<Integer, Integer> unsortMap) {

		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(unsortMap.entrySet());
		List<Integer> newlist = new ArrayList<>();
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				int val = (o2.getValue()).compareTo(o1.getValue());
				if (val == 0) {
					return o1.getKey().compareTo(o2.getKey());
				}
				return val;
			}
		});
		for (Map.Entry<Integer, Integer> entry : list) {
			newlist.add(entry.getKey());
		}
		return newlist;
	}

}
