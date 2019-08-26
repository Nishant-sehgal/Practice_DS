package com.pattern.strategy;

public class MalardDuck extends Duck {

	MalardDuck(QuackBehavior quackBehavior,FlyBehavior flyBehavior){
		this.quackBehavior = quackBehavior;
		this.flyBehavior = flyBehavior;
	}

	public void dispaly() {
		System.out.println("I am Malard Duck");
	}
}
