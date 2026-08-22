package com.lld.coffee.machine.state;

import com.lld.coffee.machine.enums.ProductType;
import com.lld.coffee.machine.models.CoffeeMachine;
import com.lld.coffee.machine.models.Inventory;

public class OutOfStockState implements IMachineState{
    @Override
    public void selectProduct(CoffeeMachine cm, ProductType pt) {

    }

    @Override
    public void prepare(CoffeeMachine cm) {

    }

    @Override
    public void dispense(CoffeeMachine cm) {

    }

    @Override
    public void outOfStock(CoffeeMachine cm){
        System.out.println("Out of stock pls add inventory");
        cm.setMachineState(new FillingState());

    }

    @Override
    public void filling(CoffeeMachine cm, Inventory inventory) {

    }
    @Override
    public void cancel(CoffeeMachine cm) {
        System.out.println("cannot cancel order at this point");
    }
}
