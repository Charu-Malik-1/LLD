package com.lld.coffee.machine.factory;

import com.lld.coffee.machine.enums.ProductType;
import com.lld.coffee.machine.strategy.DarkCoffeeReceipeStrategy;
import com.lld.coffee.machine.strategy.IReceipeStrategy;
import com.lld.coffee.machine.strategy.SimpleCoffeeReceipeStrategy;
import com.lld.coffee.machine.strategy.TeaReceipeStrategy;

public class ReceipeFactory {

    public static IReceipeStrategy getReceipeObject(ProductType productType){
        IReceipeStrategy ob = null;

        switch (productType) {

            case COFFEE:
                ob = new SimpleCoffeeReceipeStrategy();
                break;

            case TEA:
                ob = new TeaReceipeStrategy();
                break;

            case DARK_COFFEE:
                ob = new DarkCoffeeReceipeStrategy();
                break;
        }

        return ob;
    }
}
