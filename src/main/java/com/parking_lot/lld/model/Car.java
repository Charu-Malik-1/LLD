package com.parking_lot.lld.model;

import com.parking_lot.lld.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car extends Vehicle{

    public Car(int id,String color){
        super(id,color,VehicleType.CAR);
    }
}
