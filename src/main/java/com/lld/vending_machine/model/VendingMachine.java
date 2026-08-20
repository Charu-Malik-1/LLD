package com.lld.vending_machine.model;

import com.lld.vending_machine.state.IVendingState;
import com.lld.vending_machine.state.IdleState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendingMachine {
    private IVendingState currentState;
    private int currentAmt;
    private Inventory inventory;
    private static VendingMachine instance=null;

    public static VendingMachine getInstance(Inventory inventory) {
        if (instance == null) {
            synchronized (VendingMachine.class) {
                if (instance == null) {
                    instance = new VendingMachine(inventory);
                }
            }
        }
        return instance;
    }

    private VendingMachine(Inventory inventory) {
        currentState = new IdleState();
        currentAmt = 0;
        this.inventory = inventory;
    }
}
