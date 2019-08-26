package com.pattern.strategy;

public class LoudQuacking implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Quacking Loudly");
	}

}
