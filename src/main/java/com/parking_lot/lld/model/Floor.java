package com.parking_lot.lld.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Floor {
    private final int id;
    private final Map<Integer, ParkingSlot> parkingSlotMap;

    public Floor(int id) {
        this.id = id;
        parkingSlotMap = new HashMap<>();
    }

    public ParkingSlot getAvailableSlot(Vehicle vehicle) {
        for (Map.Entry<Integer, ParkingSlot> e : parkingSlotMap.entrySet()) {
            ParkingSlot ps = e.getValue();
            if (ps.isAvailable() && ps.getVehicle().getVehicleType().equals(vehicle.getVehicleType())) {
                return ps;
            }
        }
        return null;
    }
}
