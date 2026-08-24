package com.lld.elevator.model;

import com.lld.elevator.enums.Direction;
import com.lld.elevator.enums.RequestType;
import com.lld.elevator.observer.ElevatorSubscriber;
import com.lld.elevator.state.IElevatorState;
import com.lld.elevator.state.IdleState;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Elevator implements Runnable {
    private final int id;
    private IElevatorState currentState;
    private int currentFloor;
    private final int maxFloor;
    private final int minFloor;
    private TreeSet<Integer> upQueue;
    private TreeSet<Integer> downQueue;
    private InternalPanel internalPanel;
    private Direction direction;
    private boolean flag;
    List<ElevatorSubscriber> elevatorSubscribers;

    public Elevator(int id, int max, int min, Display display,List<ElevatorSubscriber> elevatorSubscribers) {
        this.id = id;
        this.maxFloor = max;
        this.minFloor = min;
        upQueue = new TreeSet<>();
        downQueue = new TreeSet<>(Collections.reverseOrder());
        currentFloor = 0;
        currentState = new IdleState();
        direction = Direction.IDLE;
        List<Integer> floors = new ArrayList<>();
        for (int i = minFloor; i <= maxFloor; i++)
            floors.add(i);
        internalPanel = new InternalPanel(floors, display);
        flag = true;
        this.elevatorSubscribers=elevatorSubscribers;
    }

    public void notifyObservers() {
        for(int i=0;i< elevatorSubscribers.size();i++)
        elevatorSubscribers.get(i).show();
    }

    public void run() {
        while (true) {
            synchronized (this) {
                while (upQueue.isEmpty() && downQueue.isEmpty()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        //    System.out.println("current floor : " + currentFloor);
            move();
        }
    }

    public synchronized void move() {
        notifyObservers();
        currentState.move(this);
    }

    public synchronized void request(int requestedFloor) {
        if (requestedFloor > maxFloor || requestedFloor < minFloor) {
            System.out.println("wrong floor");
            return;
        }
        currentState.addRequest(this, requestedFloor);
        flag = true;
        notify();
    }
}
