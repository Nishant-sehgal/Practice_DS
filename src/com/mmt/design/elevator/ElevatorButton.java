package com.mmt.design.elevator;

public class ElevatorButton extends Button {

	@Override
	public void placeRequest() {
		this.elevatorRequest.addRequest();

	}

}
