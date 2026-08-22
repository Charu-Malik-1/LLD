package com.lld.coffee.machine.state;

import com.lld.coffee.machine.enums.ProductType;
import com.lld.coffee.machine.models.CoffeeMachine;
import com.lld.coffee.machine.models.Inventory;

public interface IMachineState {
    void selectProduct(CoffeeMachine cm, ProductType pt);
    void prepare(CoffeeMachine cm);
    void dispense(CoffeeMachine cm);
    void outOfStock(CoffeeMachine cm);
    void filling(CoffeeMachine cm, Inventory inventory);
    void cancel(CoffeeMachine cm);
}
