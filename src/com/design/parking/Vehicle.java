package com.design.parking;

/**
 * @author MMT5680
 *
 */
interface Vehicle {

	abstract boolean canFitInSmallSlot();

	abstract boolean canFitInCompactSlot();

	abstract boolean canFitInLargeSlot();

}
