package com.lld.atm.atm.lld.practice.state;

import com.lld.atm.atm.lld.practice.enums.AtmState;
import com.lld.atm.atm.lld.practice.models.Atm;
import com.lld.atm.atm.lld.practice.models.Card;
import com.lld.atm.atm.lld.practice.models.Transaction;

public class DispenseCashState implements IAtmState {
    private Atm atm;

    public DispenseCashState(Atm atm){
        this.atm=atm;
    }
    @Override
    public void startTransaction() {
        System.out.println("Invalid from dispenseCash to start-trans");
    }


    @Override
    public void insertCard() {
        System.out.println("Invalid from dispenseCash to insertCard");
    }

    @Override
    public void enterAmountAndPinState() {
        System.out.println("Invalid from dispenseCash to enterAmountAndPin");
    }

    @Override
    public void dispenseCash() {
        System.out.println("dispensing cash..."+atm.getCurrentTransaction().getAmount());
        atm.changeState(new EjectCardState(atm));
    }

    @Override
    public void ejectCard() {
        System.out.println("Invalid from dispenseCash to ejectCard");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Invalid from dispenseCash to cancelTrans");
    }

    @Override
    public AtmState getState() {
        return AtmState.DISPENSE_CASH;
    }
}
