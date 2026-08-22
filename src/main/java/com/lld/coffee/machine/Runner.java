package com.lld.coffee.machine;

import com.lld.coffee.machine.enums.ProductType;
import com.lld.coffee.machine.models.CoffeeMachine;
import com.lld.coffee.machine.models.Inventory;

public class Runner {

    public void runner() {
        Inventory inventory = new Inventory();
        inventory.addInventory(100, 100, 5, 30);
        CoffeeMachine cm = CoffeeMachine.getInstance(inventory);

//        success case
        cm.getMachineState().selectProduct(cm, ProductType.COFFEE);
        cm.getMachineState().prepare(cm);
        cm.getMachineState().dispense(cm);

        inventory.addInventory(100, 100, 10, 30);
        // when inventory not available
        cm.getMachineState().selectProduct(cm, ProductType.COFFEE);
        cm.getMachineState().prepare(cm);
        cm.getMachineState().dispense(cm);

        // when user slect wrong prod
        cm.getMachineState().selectProduct(cm, ProductType.COFFEE);
        cm.getMachineState().prepare(cm);
        cm.getMachineState().dispense(cm);

    }
}
