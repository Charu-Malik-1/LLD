package com.lld.coffee.machine.strategy;

import com.lld.coffee.machine.models.CoffeeMachine;
import com.lld.coffee.machine.models.Inventory;

public class DarkCoffeeReceipeStrategy implements IReceipeStrategy {
    private final int coffee;
    private final int suger;
    private final int milk;

    public DarkCoffeeReceipeStrategy(){
        coffee=20;
        suger=2;
        milk=10;
    }
    @Override
    public boolean isInventoryAvailable(CoffeeMachine cm){
        Inventory i=cm.getInventory();
        if(i.getMilk()>=milk && i.getCoffee()>=coffee && i.getSuger()>=suger){
            return true;
        }
        return false;
    }
    @Override
    public void prepare(CoffeeMachine cm){
        System.out.println("preparing coffee...");
        cm.getInventory().reduceInventory(milk,0,coffee,suger);
    }
}
