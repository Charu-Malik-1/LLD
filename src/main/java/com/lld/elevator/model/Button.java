package com.lld.elevator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Button {
    private boolean isPressed;
    private final String id;

    public Button(String id) {
        this.id = id;
        isPressed = false;
    }
}
