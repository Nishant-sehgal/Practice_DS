package com.pattern.adapter;

import java.util.Collections;
import java.util.List;

public class IntegerSorter implements Sorter {

	@Override
	public void sort(List<Integer> integersList) {
		Collections.sort(integersList);

	}

}
