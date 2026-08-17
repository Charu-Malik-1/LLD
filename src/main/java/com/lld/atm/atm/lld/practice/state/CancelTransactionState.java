package com.lld.atm.atm.lld.practice.state;

import com.lld.atm.atm.lld.practice.enums.AtmState;
import com.lld.atm.atm.lld.practice.models.Atm;

public class CancelTransactionState implements IAtmState {
    private Atm atm;

    public CancelTransactionState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void startTransaction() {
        System.out.println("Invalid from cancelTrans to startTrans");
    }

//    @Override
//    public void insertCardAndPin() {
//        System.out.println("Invalid from cancelTrans to insertCard");
//    }

    @Override
    public void insertCard() {

    }

    @Override
    public void enterAmountAndPinState() {
        System.out.println("Invalid from cancelTrans to enterAmtAndPin");
    }

    @Override
    public void dispenseCash() {
        System.out.println("Invalid from cancelTrans to dispneseCash");
    }

    @Override
    public void ejectCard() {
        System.out.println("Invalid from cancelTrans to ejectCard");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Invalid from cancelTrans to cancelTrans");
    }

    @Override
    public AtmState getState() {
        return AtmState.CANCEL;
    }
}
