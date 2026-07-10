package org.example.state;

import lombok.Getter;
import org.example.model.VendingMachine;

@Getter
public class SoldOutState implements StateInterface {
    private final VendingMachine vm;

    public SoldOutState(VendingMachine vm) {
        this.vm = vm;
    }

    @Override
    public void insertCoin(int coin) {

    }

    @Override
    public void selectItem(int itemNum) {

    }

    @Override
    public void dispenseItem(int itemId) {

    }

    @Override
    public void returnCoin() {

    }
}
