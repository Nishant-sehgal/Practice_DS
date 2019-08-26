package com.mmt.design.elevator;

public class Elevator {

	private String currentFloor;

	private Integer noOfFloors;

	enum state {
		STAND, MAINTAINCE;
	}

	// Each time it reaches a floor, it checks if it needs to stop. If so it
	// stops and opens the doors. It waits for a certain amount of time and
	// closes the door . Then it removes the floor from the request list and
	// checks if there is another request.
	// If so the elevator starts moving again. If not it enters the state stand.
	public void moveUp() {

	}

	public void moveDown() {

	}

	// opens the lift if elevator is on the floor and not moving
	public void openLift() {

	}

	// closes lift if it is open
	public void CloseLift() {

	}

}
