package com.pattern.decorator;

public class DarkRoast extends Beverage {

	@Override
	public void description() {
		System.out.println("Preparing Dark Roast");
	}

	@Override
	public int cost() {
		return 100;
	}

}
