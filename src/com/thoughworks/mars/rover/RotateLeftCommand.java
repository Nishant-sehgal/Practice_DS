package com.thoughworks.mars.rover;

public class RotateLeftCommand implements ICommand{

	@Override
	public void execute(MarsRover rover) {
		rover.turnLeft();

	}

}
