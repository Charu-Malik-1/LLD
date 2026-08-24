package com.lld.elevator.state;

import com.lld.elevator.enums.Direction;
import com.lld.elevator.model.Elevator;

public class MovingDownState implements IElevatorState {
    @Override
    public void addRequest(Elevator e, int requestedFloor) {
        if (requestedFloor < e.getCurrentFloor()) {
            e.getDownQueue().add(requestedFloor);
            e.setDirection(Direction.DOWN);
            e.setFlag(true);
        }
        else if (requestedFloor == e.getCurrentFloor()) {
            System.out.println("we are at floor -- "+ requestedFloor+" -- moving down");
            e.getDownQueue().remove(requestedFloor);
            e.setDirection(Direction.DOWN);
            e.setFlag(true);
        }
        else {
            e.getUpQueue().add(requestedFloor);
        }
    }

    @Override
    public void move(Elevator e) {
        if(e.getUpQueue().isEmpty() && e.getDownQueue().isEmpty()){
            e.setCurrentState(new IdleState());
            e.setDirection(Direction.IDLE);
            e.setFlag(false);
        }
        else if(!e.getDownQueue().isEmpty()){
            int nextFloor = e.getDownQueue().first();
            if (nextFloor < e.getCurrentFloor()) {
                e.setCurrentFloor(e.getCurrentFloor() - 1);
            }
            if (nextFloor == e.getCurrentFloor()) {
                System.out.println("we are at floor -- "+ e.getCurrentFloor()+" -- moving down");
                e.getDownQueue().remove(nextFloor);
                e.setCurrentFloor(e.getCurrentFloor() - 1);
            }
        }
        else if(!e.getUpQueue().isEmpty())
        {
            e.setDirection(Direction.UP);
            e.setFlag(true);
            e.setCurrentState(new MovingUpState());
        }
    }



}
