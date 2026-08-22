package com.lld.coffee.machine.models;

import com.lld.coffee.machine.state.IMachineState;
import com.lld.coffee.machine.strategy.IReceipeStrategy;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Inventory {
    private int milk;
    private int tea;
    private int coffee;
    private int suger;

    public void Inventory(int milk, int tea, int coffee, int suger) {
        this.milk = milk;
        this.tea = tea;
        this.coffee = coffee;
        this.suger = suger;
    }

    public void addInventory(int milk, int tea, int coffee, int suger) {
        this.milk += milk;
        this.tea += tea;
        this.coffee += coffee;
        this.suger += suger;
    }

    public void reduceInventory(int milk, int tea, int coffee, int suger) {
        this.milk -= milk;
        this.tea -= tea;
        this.coffee -= coffee;
        this.suger -= suger;
    }
}
