package com.lld.coffee.machine.models;

import com.lld.coffee.machine.state.IMachineState;
import com.lld.coffee.machine.state.IdleState;
import com.lld.coffee.machine.strategy.IReceipeStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoffeeMachine {
    private static CoffeeMachine cm;
    private  IMachineState machineState;
    private IReceipeStrategy receipeStrategy;
    private final Inventory inventory;

    public static CoffeeMachine getInstance(Inventory inventory) {
        if (cm == null) {
            synchronized (CoffeeMachine.class) {
                if (cm == null) {
                    cm = new CoffeeMachine(inventory);
                }
            }
        }
        return cm;
    }

    private CoffeeMachine(Inventory inventory) {
        machineState = new IdleState();
        receipeStrategy = null;
        this.inventory = inventory;
    }


}
