package com.parking_lot.lld.model;

import com.parking_lot.lld.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle {
    private final int id;
    private final String color;
    private final VehicleType vehicleType;

    public Vehicle(int id, String color,VehicleType vehicleType) {
        this.id = id;
        this.color = color;
        this.vehicleType=vehicleType;
    }
}
