package com.pattern.decorator;

public class Main {

	public static void main(String[] args) {

		Beverage beverage = new Milk(new Soya(new DarkRoast()));
		System.out.println("Beverage Description::");
		beverage.description();
		System.out.println("Total Cost::"+beverage.cost());

		System.out.println("*****************************************");

		Beverage beverage2 = new DarkRoast();
		beverage2 = new Whip(beverage2);
		beverage2 = new Milk(beverage2);
		System.out.println("Beverage Description::");
		beverage2.description();
		System.out.println("Total Cost::"+beverage2.cost());
	}

}
