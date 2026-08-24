package com.lld.elevator;

import com.lld.elevator.enums.RequestType;
import com.lld.elevator.model.Display;
import com.lld.elevator.model.Elevator;
import com.lld.elevator.observer.ElevatorSubscriber;

import java.util.ArrayList;
import java.util.List;


public class Runner {
    public void runner() {

        Building building = new Building();
        Display display = new Display();
        List<ElevatorSubscriber> es=new ArrayList<>();
        es.add(display);
        Elevator elevator1 = new Elevator(1, 10, 0, display,es);
        Elevator elevator2 = new Elevator(2, 10, 0, display,es);

        building.addElevator(elevator1);
        building.addElevator(elevator2);

        int count=1;
        for (int j = 1; j <= 10; j++) {
            for (int i = 1; i < 10; i++) {
                System.out.println(count);
                count++;
                building.requestElevator(i);
            }
        }
    }
}
