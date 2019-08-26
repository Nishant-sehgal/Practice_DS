package com.mmt.design.elevator;

public class OpenDoorCommand extends Command {

	private Elevator elevator;

	public OpenDoorCommand(Elevator e) {
		this.elevator = e;
	}

	@Override
	public void execute() {
		elevator.openLift();
	}

}
