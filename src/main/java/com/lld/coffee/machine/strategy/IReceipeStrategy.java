package com.lld.coffee.machine.strategy;

import com.lld.coffee.machine.models.CoffeeMachine;

public interface IReceipeStrategy {
    boolean isInventoryAvailable(CoffeeMachine cm);

    void prepare(CoffeeMachine cm);
}
