package com.lld.vending_machine.state;

import com.lld.vending_machine.model.VendingMachine;

public interface IVendingState {
    void insertCoin(VendingMachine vm, int coin);
    int selectProduct(VendingMachine vm, int rackNum);
    void dispenseProduct(VendingMachine vm);
    void returnCoin(VendingMachine vm);
}
