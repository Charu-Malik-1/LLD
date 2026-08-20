package com.lld.vending_machine.state;

import com.lld.vending_machine.model.VendingMachine;

public class ReturnCoinState implements IVendingState {

    public ReturnCoinState(){
        System.out.println("--------------RETURN-COIN-STATE-----------------");
    }

    @Override
    public void returnCoin(VendingMachine vm) {
        int amt = vm.getCurrentAmt();
        System.out.println("returning amt " + amt);
        vm.setCurrentState(new IdleState());
        vm.setCurrentAmt(0);
    }

    @Override
    public void insertCoin(VendingMachine vm, int coin) {
    }

    @Override
    public int selectProduct(VendingMachine vm, int rackNum) {
        return 2;
    }

    @Override
    public void dispenseProduct(VendingMachine vm) {
    }
}
