package com.pattern.decorator;

public class Whip extends Decorator {

	Beverage beverage;

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	@Override
	public int cost() {
		return beverage.cost() + 10;
	}

	@Override
	public void description() {
		beverage.description();
		System.out.println("Added Whip");
	}
}
