package com.design.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MMT5680
 *
 */
public class ParkingLot {

	private static final int NUMBER_OF_SMALL_SLOTS = 10;
	private static final int NUMBER_OF_COMPACT_SLOTS = 10;
	private static final int NUMBER_OF_LARGE_SLOTS = 10;
	public Map<Long, Slot> occupiedSlots;
	private List<Slot> smallSlots;
	private List<Slot> compactSlots;
	private List<Slot> largeSlots;
	private ParkingHelper parkingHelper = ParkingHelper.getInstance();

	public ParkingLot() {
		smallSlots = new ArrayList<>(NUMBER_OF_SMALL_SLOTS);
		compactSlots = new ArrayList<>(NUMBER_OF_COMPACT_SLOTS);
		largeSlots = new ArrayList<>(NUMBER_OF_LARGE_SLOTS);
		createSlots();
		occupiedSlots = new HashMap<>();
	}

	private void createSlots() {

		for (int i = 1; i <= NUMBER_OF_SMALL_SLOTS; i++) {
			smallSlots.add(new SmallSlot(i));
		}
		for (int i = 1; i <= NUMBER_OF_COMPACT_SLOTS; i++) {
			compactSlots.add(new CompactSlot(i));
		}
		for (int i = 1; i <= NUMBER_OF_LARGE_SLOTS; i++) {
			largeSlots.add(new LargeSlot(i));
		}

	}

	public long park(Vehicle vehicle) {

		Slot slot;
		long uniqueToken = -1;

		if (vehicle.canFitInSmallSlot()) {
			if ((slot = parkingHelper.getFirstEmptySlot(smallSlots)) != null) {
				uniqueToken = parkingHelper.generateToken(slot, vehicle,occupiedSlots);
			}
		}
		if (vehicle.canFitInCompactSlot()) {
			if ((slot = parkingHelper.getFirstEmptySlot(compactSlots)) != null) {
				uniqueToken = parkingHelper.generateToken(slot, vehicle,occupiedSlots);
			}
		}

		if (vehicle.canFitInLargeSlot()) {
			if ((slot = parkingHelper.getFirstEmptySlot(largeSlots)) != null) {
				uniqueToken = parkingHelper.generateToken(slot, vehicle,occupiedSlots);
			}
		}
		return uniqueToken;
	}

	public void unPark(long uniqueToken) {
		parkingHelper.emptyParking(uniqueToken, occupiedSlots);
	}
}
