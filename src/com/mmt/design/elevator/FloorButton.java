package com.mmt.design.elevator;

public class FloorButton extends Button {

	@Override
	public void placeRequest() {
		this.elevatorRequest.addRequest();

	}

}
