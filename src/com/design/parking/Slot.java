package com.design.parking;

/**
 * @author MMT5680
 *
 */
abstract class Slot {

	private boolean isOccupied;
	private int slotNumber;
	private Vehicle vehicle;

	Slot(int slotNumber) {
		isOccupied = false;
		this.slotNumber = slotNumber;
	}

	boolean isOccupied() {
		return isOccupied;
	}

	int getSlotNumber() {
		return slotNumber;
	}

	void park(Vehicle vehicle) {
		isOccupied = true;
		this.vehicle = vehicle;
	}

	void unPark() {
		this.vehicle = null;
		isOccupied = false;
	}

	@Override
	public boolean equals(Object o) {
		return (((Slot) o).slotNumber == this.slotNumber);
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 53 * hash + this.slotNumber;
		return hash;
	}

	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}