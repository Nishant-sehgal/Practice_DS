package com.pattern.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SorterAdapter {

	private Sorter sorter;

	SorterAdapter(Sorter sorter){
		this.sorter = sorter;
	}

	public void sortArray(int[] numbers){
		List<Integer> integersList = new ArrayList<>();
		Arrays.asList("","");
		sorter.sort(integersList);
	}
}
