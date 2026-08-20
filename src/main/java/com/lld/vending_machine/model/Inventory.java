package com.lld.vending_machine.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class Inventory {
    public final Map<Integer, Rack> racks;

    public Inventory() {
        racks = new HashMap<>();
    }

    public void addRack(Rack rack) {
        racks.put(rack.getRackId(), rack);
    }
}
