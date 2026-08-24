package com.lld.elevator.strategy;

import com.lld.elevator.model.Elevator;

import java.util.Map;

public interface IElevatorSelectionStrategy {
    Elevator getElevator(Map<Integer,Elevator> map);
}
