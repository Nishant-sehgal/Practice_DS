package com.pattern.strategy;

public class Main {

	public static void main(String[] args) {
		Duck duck = new MalardDuck(new MuteQuack(), new FlyWithRocket());
		duck.performFly();
		duck.performQuack();
	}

}
