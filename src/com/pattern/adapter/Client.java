package com.pattern.adapter;

public class Client {

	public void sort(int[] numbers) {
		SorterAdapter adapter = new SorterAdapter(new IntegerSorter());
		adapter.sortArray(numbers);
	}
}
