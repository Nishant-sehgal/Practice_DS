package com.pattern.decorator;

public class Milk extends Decorator {

	Beverage beverage;

	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public int cost() {
		return beverage.cost() + 20;
	}

	@Override
	public void description() {
		beverage.description();
		System.out.println("Added Milk");
	}
}
