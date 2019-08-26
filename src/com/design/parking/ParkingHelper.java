package com.design.parking;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author MMT5680
 *
 */
public class ParkingHelper {

	private final static ParkingHelper parkingHelper = new ParkingHelper();

	public long generateToken(Slot slot, Vehicle vehicle, Map<Long, Slot> occupiedSlots) {
		slot.park(vehicle);
		long uniqueToken = vehicle.hashCode() * 43;
		occupiedSlots.put(uniqueToken, slot);
		return uniqueToken;
	}

	public void emptyParking(long uniqueToken, Map<Long, Slot> occupiedSlots) {
		occupiedSlots.get(uniqueToken).unPark();
		occupiedSlots.remove(uniqueToken);
	}

	public Slot getFirstEmptySlot(List<Slot> slots) {
		Iterator<Slot> slotIterator = slots.iterator();
		boolean isSlotFound = false;
		Slot emptySlot = null;

		while (slotIterator.hasNext() && !isSlotFound) {
			emptySlot = slotIterator.next();
			if (!emptySlot.isOccupied()) {
				isSlotFound = true;
			}
		}
		return emptySlot;
	}


	public static ParkingHelper getInstance() {
		return parkingHelper;
	}
}
