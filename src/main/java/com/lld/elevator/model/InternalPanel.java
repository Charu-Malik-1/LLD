package com.lld.elevator.model;

import com.lld.elevator.enums.Direction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InternalPanel extends Panel {
    private final List<Integer> floor;
    private int currentFloor;
    private Direction direction;
    private Button openButton;
    private Button closeButton;

    public InternalPanel(List<Integer> f,Display display) {
        super(display);
        currentFloor = 0;
        direction = Direction.IDLE;
        this.floor=f;
        openButton=new Button("internal-open");
        closeButton=new Button("internal-close");
    }
}
