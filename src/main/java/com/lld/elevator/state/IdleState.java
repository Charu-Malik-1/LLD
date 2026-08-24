package com.lld.elevator.state;

import com.lld.elevator.enums.Direction;
import com.lld.elevator.model.Elevator;

public class IdleState implements IElevatorState{

    @Override
    public void addRequest(Elevator e,int requestedFloor){

        if (requestedFloor > e.getCurrentFloor()) {
            e.getUpQueue().add(requestedFloor);
            e.setCurrentState(new MovingUpState());
            e.setDirection(Direction.UP);
            e.setFlag(true);
        } else {
            e.getDownQueue().add(requestedFloor);
            e.setCurrentState(new MovingDownState());
            e.setDirection(Direction.DOWN);
            e.setFlag(true);
        }
    }

    @Override
    public void move(Elevator e){
        if(e.getUpQueue().isEmpty() && e.getDownQueue().isEmpty()){
            //stay ideal;
            e.setDirection(Direction.IDLE);
            e.setFlag(false);
        }
        if(!e.getUpQueue().isEmpty()){
            e.setCurrentState(new MovingUpState());
            e.setDirection(Direction.UP);
            e.setFlag(true);
        }
        else if(!e.getDownQueue().isEmpty()){
            e.setCurrentState(new MovingDownState());
            e.setDirection(Direction.DOWN);
            e.setFlag(true);
        }
    }
}
