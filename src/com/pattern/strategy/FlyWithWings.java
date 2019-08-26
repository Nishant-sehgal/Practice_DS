package com.pattern.strategy;

public class FlyWithWings implements FlyBehavior{

	@Override
	public void fly() {
		System.out.println("FLying with wings");
	}

}
