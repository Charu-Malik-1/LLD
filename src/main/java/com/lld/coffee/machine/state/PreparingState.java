package com.lld.coffee.machine.state;

import com.lld.coffee.machine.enums.ProductType;
import com.lld.coffee.machine.models.CoffeeMachine;
import com.lld.coffee.machine.models.Inventory;
import com.lld.coffee.machine.strategy.IReceipeStrategy;

public class PreparingState implements IMachineState{

    @Override
    public void selectProduct(CoffeeMachine cm, ProductType pt) {

    }

    @Override
    public void prepare(CoffeeMachine cm){
       IReceipeStrategy rs= cm.getReceipeStrategy();
       rs.prepare(cm);
       cm.setMachineState(new DispenseState());
    }

    @Override
    public void dispense(CoffeeMachine cm) {

    }

    @Override
    public void outOfStock(CoffeeMachine cm) {

    }

    @Override
    public void filling(CoffeeMachine cm, Inventory inventory) {

    }
    @Override
    public void cancel(CoffeeMachine cm){
        cm.setMachineState(new CancelState());
    }
}
