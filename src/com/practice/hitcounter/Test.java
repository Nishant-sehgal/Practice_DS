package com.practice.hitcounter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		Map<String,String> test = Collections.unmodifiableMap(map);
		test.put("1", "2");

	}

}
