package com.parking_lot.lld.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectricCar extends Vehicle{

    public ElectricCar(int id,String color){
        super(id,color);
    }
}
