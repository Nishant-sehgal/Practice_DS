package com.mmt.design.elevator;

public abstract class Button {

	protected String time;
	protected String direction;
	protected String floor;

	protected ElevatorRequest elevatorRequest = new ElevatorRequest();

	public void elliminate(){

	}

	public abstract void placeRequest();
}
