package com.lld.atm.atm.lld.practice.state;

import com.lld.atm.atm.lld.practice.enums.AtmState;
import com.lld.atm.atm.lld.practice.models.Atm;

public class InitiateTransactionState implements IAtmState {
    private Atm atm;

    public InitiateTransactionState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void startTransaction() {
        atm.changeState(new InsertCardState(atm));
    }

    @Override
    public void insertCard() {
        System.out.println("invalid state.. first start the transaction");
    }

    @Override
    public void enterAmountAndPinState() {
        System.out.println("invalid state.. first start the transaction");
    }

    @Override
    public void dispenseCash() {
        System.out.println("invalid state.. first start the transaction");
    }

    @Override
    public void ejectCard() {
        System.out.println("invalid state.. first start the transaction");
    }

    @Override
    public void cancelTransaction() {

    }

    @Override
    public AtmState getState() {
        return AtmState.START_TRANSACTION;
    }
}
