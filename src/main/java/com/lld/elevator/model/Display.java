package com.lld.elevator.model;

import com.lld.elevator.enums.Direction;
import com.lld.elevator.observer.ElevatorSubscriber;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Display implements ElevatorSubscriber {
    private int currentFloor;
    private Direction direction;

    public Display() {
        currentFloor = 0;
        direction = Direction.IDLE;
    }

    @Override
    public void show(){
        System.out.println("showing the current floor on display");
    }
}
