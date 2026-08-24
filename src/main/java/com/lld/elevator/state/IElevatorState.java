package com.lld.elevator.state;

import com.lld.elevator.model.Elevator;

public interface IElevatorState {
//    void movingUp(Elevator e);
//
//    void movingDown(Elevator e);

    void addRequest(Elevator e, int requestedFloor);
    void move(Elevator e);
}
