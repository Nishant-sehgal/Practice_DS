package com.pattern.strategy;

public class MuteQuack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("Mute Quacking");
	}

}
