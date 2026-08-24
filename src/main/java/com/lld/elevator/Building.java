package com.lld.elevator;

import com.lld.elevator.model.Display;
import com.lld.elevator.model.Elevator;
import com.lld.elevator.strategy.IElevatorSelectionStrategy;
import com.lld.elevator.strategy.NearestElevatorStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Building {
    Map<Integer, Elevator> elevatorMap;
    ExecutorService es;
    IElevatorSelectionStrategy iElevatorSelectionStrategy;

    public Building() {
        elevatorMap = new HashMap<>();
        es = Executors.newFixedThreadPool(2);
        iElevatorSelectionStrategy = new NearestElevatorStrategy();
    }

    public void addElevator(Elevator e) {
        elevatorMap.put(e.getId(), e);
        es.submit(e);
    }

//    public void shutdown() {
//        for (Elevator elevator : elevatorMap.values()) {
//            elevator.stop();
//        }
//        executorService.shutdown();
//        try {
//            if (!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
//                executorService.shutdownNow();
//            }
//        } catch (InterruptedException exception) {
//            executorService.shutdownNow();
//            Thread.currentThread().interrupt();
//        }
//    }

    public void requestElevator(int floor) {
        Elevator e = iElevatorSelectionStrategy.getElevator(elevatorMap);
//        System.out.println("getting the elevator "+e.getId());
        e.request(floor);
    }

    public void stopAllElevators(){
        //todo stop elevator
//        for (Elevator elevator : elevatorMap.values()) {
//            elevator.stop();
//        }
        es.shutdown();
    }

//    public void runner() {
//
//        Display display = new Display();
//        Elevator elevator = new Elevator(1, 10, 0, display);
//        Elevator elevator2 = new Elevator(2, 10, 0, display);
//        addElevator(elevator);
//        addElevator(elevator2);
//
//
//        Thread t = new Thread(elevator);
//        t.start();
//        elevator.request(2);
//        elevator.request(5);
//        elevator.request(8);
//
//        try {
//            System.out.println("sleep--");
//            t.sleep(10000);
//            elevator.request(2);
//            elevator.request(5);
//        } catch (InterruptedException e) {
//        }
//
//        System.out.println("now requesting 7 floor");
//        elevator.request(7);
//    }
}
