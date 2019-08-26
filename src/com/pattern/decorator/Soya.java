package com.pattern.decorator;

public class Soya extends Decorator {

	Beverage beverage;

	public Soya(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public int cost() {
		return beverage.cost() + 15;
	}

	@Override
	public void description() {
		beverage.description();
		System.out.println("Added Soya");
	}
}
