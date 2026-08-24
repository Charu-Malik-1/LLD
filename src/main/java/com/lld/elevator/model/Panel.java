package com.lld.elevator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Panel {
    private final Display display;

    public Panel(Display display) {
        this.display = display;
    }
}
