package com.lld.elevator.strategy;

import com.lld.elevator.model.Elevator;

import java.util.Map;

public class NearestElevatorStrategy implements IElevatorSelectionStrategy{

    @Override
    public Elevator getElevator(Map<Integer,Elevator> map){
        for(Map.Entry<Integer,Elevator> e: map.entrySet()){
            return e.getValue();
        }
        return null;
    }
}
