package com.lld.elevator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Floor {
    private final int id;
    private ExternalPanel externalPanel;

    public Floor(int id,ExternalPanel e){
        this.id=id;
        this.externalPanel=e;
    }
}
