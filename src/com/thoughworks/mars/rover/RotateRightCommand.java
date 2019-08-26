package com.thoughworks.mars.rover;

public class RotateRightCommand implements ICommand {

	@Override
	public void execute(MarsRover rover) {
		rover.turnRight();

	}

}
