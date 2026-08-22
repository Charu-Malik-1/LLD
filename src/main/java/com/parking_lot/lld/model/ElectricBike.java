package com.parking_lot.lld.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectricBike extends Vehicle{

    public ElectricBike(int id,String color){
        super(id,color);
    }
}
