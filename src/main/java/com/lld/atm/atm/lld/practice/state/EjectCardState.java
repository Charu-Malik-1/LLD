package com.lld.atm.atm.lld.practice.state;

import com.lld.atm.atm.lld.practice.enums.AtmState;
import com.lld.atm.atm.lld.practice.models.Atm;
import com.lld.atm.atm.lld.practice.models.Card;
import com.lld.atm.atm.lld.practice.models.Transaction;

public class EjectCardState implements IAtmState {
    private Atm atm;

    public EjectCardState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void startTransaction() {
        System.out.println("Invalid from ejectCard to startTrans");
    }

    @Override
    public void insertCard() {
        System.out.println("Invalid from ejectCard to insertCard");
    }

    @Override
    public void enterAmountAndPinState() {
        System.out.println("Invalid from ejectCard to enterAmtAndPin");
    }

    @Override
    public void dispenseCash() {
        System.out.println("Invalid from ejectCard to dispenseCash");
    }

    @Override
    public void ejectCard() {
        System.out.println("ejecting card");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Invalid from ejectCard to cancelTrabs");
    }

    @Override
    public AtmState getState() {
        return AtmState.EJECTING_CARD;
    }
}
