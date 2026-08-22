package com.lld.coffee.machine.strategy;

import com.lld.coffee.machine.models.CoffeeMachine;
import com.lld.coffee.machine.models.Inventory;



public class TeaReceipeStrategy implements IReceipeStrategy {
    private final int tea;
    private final int suger;
    private final int milk;

    public TeaReceipeStrategy(){
        tea=10;
        suger=2;
        milk=10;
    }
    @Override
    public boolean isInventoryAvailable(CoffeeMachine cm){
        Inventory i=cm.getInventory();
        if(i.getMilk()>=10 && i.getTea()>=10 && i.getSuger()>=2){
            return true;
        }
        return false;
    }
    @Override
    public void prepare(CoffeeMachine cm){

        System.out.println("preparing tea...");
        cm.getInventory().reduceInventory(milk,tea,0,suger);

    }
}
