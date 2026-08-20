package com.lld.vending_machine.state;

import com.lld.vending_machine.model.VendingMachine;

public class IdleState implements IVendingState {

    public IdleState(){
        System.out.println("--------------IDLE-STATE-----------------");
    }

    @Override
    public void insertCoin(VendingMachine vm, int coin) {
        if (coin > 0) {
            System.out.println("Inserted valid coin");
            int amt = vm.getCurrentAmt();
            amt = amt + coin;
            vm.setCurrentAmt(amt);
            vm.setCurrentState(new HasCoinState());
        } else {
            System.out.println("returning ur coin");
            vm.setCurrentState(new ReturnCoinState());
        }
    }

    @Override
    public int selectProduct(VendingMachine vm, int rackNum){
        return 2;
    }
    @Override
    public void dispenseProduct(VendingMachine vm){}
    @Override
    public void returnCoin(VendingMachine vm){}
}
