package com.thoughworks.mars.rover;

public class MoveCommand implements ICommand{

	@Override
	public void execute(MarsRover rover) {
		rover.move();

	}

}
