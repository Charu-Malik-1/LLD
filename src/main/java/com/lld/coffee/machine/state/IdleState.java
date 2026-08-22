package com.lld.coffee.machine.state;

import com.lld.coffee.machine.enums.ProductType;
import com.lld.coffee.machine.factory.ReceipeFactory;
import com.lld.coffee.machine.models.CoffeeMachine;
import com.lld.coffee.machine.models.Inventory;
import com.lld.coffee.machine.strategy.IReceipeStrategy;

public class IdleState implements IMachineState {

    @Override
    public void selectProduct(CoffeeMachine cm, ProductType pt) {
        IReceipeStrategy rs = ReceipeFactory.getReceipeObject(pt);
        boolean isAvailable = rs.isInventoryAvailable(cm);
        cm.setReceipeStrategy(rs);
        if (isAvailable) {
            System.out.println("inventory available..going to prepare...");
            cm.setMachineState(new PreparingState());
        } else {
            System.out.println("inventory not available..");
            cm.setMachineState(new OutOfStockState());
        }
    }

    @Override
    public void prepare(CoffeeMachine cm) {

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
    public void cancel(CoffeeMachine cm) {
        System.out.println("cannot cancel order at this point");
    }
}
