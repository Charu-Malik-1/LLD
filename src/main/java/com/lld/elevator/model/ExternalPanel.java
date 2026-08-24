package com.lld.elevator.model;

import com.lld.elevator.enums.Direction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExternalPanel extends Panel {
    private int currentFloor;
    private Direction direction;
    private Button buttonButton;
    private Button downButton;

    public ExternalPanel(List<Integer> f, Display display) {
        super(display);
        currentFloor = 0;
        direction = Direction.IDLE;
    }
}
