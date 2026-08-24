package com.lld.elevator.state;

import com.lld.elevator.enums.Direction;
import com.lld.elevator.model.Elevator;

import java.util.PriorityQueue;

public class MovingUpState implements IElevatorState {

    @Override
    public void addRequest(Elevator e, int requestedFloor) {
        if (requestedFloor > e.getCurrentFloor()) {
            e.getUpQueue().add(requestedFloor);
            e.setDirection(Direction.UP);
            e.setFlag(true);
        }
        else if (requestedFloor == e.getCurrentFloor()) {
            System.out.println("we are at floor -- "+ requestedFloor+" -- moving up");
            e.getUpQueue().remove(requestedFloor);
            e.setDirection(Direction.UP);
            e.setFlag(true);
        }
        else {
            e.getDownQueue().add(requestedFloor);
        }
    }

    @Override
    public void move(Elevator e) {
        if(e.getUpQueue().isEmpty() && e.getDownQueue().isEmpty()){
            e.setCurrentState(new IdleState());
            e.setDirection(Direction.IDLE);
            e.setFlag(false);
        }
        else if(!e.getUpQueue().isEmpty()){
            int nextFloor = e.getUpQueue().first();
            if (nextFloor > e.getCurrentFloor()) {
                e.setCurrentFloor(e.getCurrentFloor() + 1);
            }
            if (nextFloor == e.getCurrentFloor()) {
                System.out.println("we are at floor -- "+ nextFloor+" -- moving up");
                e.getUpQueue().remove(nextFloor);
                e.setCurrentFloor(e.getCurrentFloor() + 1);
            }
        }
        else if(!e.getDownQueue().isEmpty())
        {
            e.setDirection(Direction.DOWN);
            e.setCurrentState(new MovingDownState());
        }
    }
}
