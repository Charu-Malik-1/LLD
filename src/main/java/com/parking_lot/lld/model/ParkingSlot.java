package com.parking_lot.lld.model;

import com.parking_lot.lld.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSlot {
    private final int id;
    private Vehicle vehicle;
    private final VehicleType vehicleType;
    private boolean isAvailable;

    public ParkingSlot(int id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
        isAvailable = true;
    }

    public void bookSlot(Vehicle vehicle) {
        isAvailable = false;
        this.vehicle = vehicle;
    }

    public void releaseSlot() {
        isAvailable = true;
        this.vehicle = null;
    }
}
