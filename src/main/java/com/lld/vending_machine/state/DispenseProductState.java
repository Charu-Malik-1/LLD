package com.lld.vending_machine.state;

import com.lld.vending_machine.model.Rack;
import com.lld.vending_machine.model.VendingMachine;

public class DispenseProductState implements IVendingState {

    private final Rack rack;

    public DispenseProductState(Rack rack) {
        this.rack = rack;
        System.out.println("--------------DISPENSE-PRODUCT-STATE-----------------");
    }

    @Override
    public void dispenseProduct(VendingMachine vm) {
        System.out.println("dispensing product");

            boolean isDispensed = rack.dispenseProduct();
            if (isDispensed) {
                vm.setCurrentAmt(vm.getCurrentAmt()-rack.getProduct().getPrice());
                if (vm.getCurrentAmt() > 0)
                {   System.out.println("returning amt"+vm.getCurrentAmt());
                    vm.setCurrentState(new ReturnCoinState());
                }
                else
                    vm.setCurrentState(new IdleState());
            }
    }

    @Override
    public int selectProduct(VendingMachine vm, int rackNum) {
        return 2;
    }

    @Override
    public void insertCoin(VendingMachine vm, int coin) {

    }

    @Override
    public void returnCoin(VendingMachine vm) {
    }
}

