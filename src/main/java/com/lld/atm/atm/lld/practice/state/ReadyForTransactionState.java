package com.lld.atm.atm.lld.practice.state;

import com.lld.atm.atm.lld.practice.enums.AtmState;
import com.lld.atm.atm.lld.practice.models.Atm;
import com.lld.atm.atm.lld.practice.models.Transaction;

public class ReadyForTransactionState implements IAtmState {
    private Atm atm;

    public ReadyForTransactionState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void startTransaction() {
        double transactionId = generateTransaction();
        if (transactionId == 0) {
            throw new RuntimeException("transaction cannot be created");
        }
        Transaction t = new Transaction(transactionId);
        atm.setCurrentTransaction(t);
        atm.changeState(new InsertCardState(atm));
    }

    @Override
    public void insertCard() {
        System.out.println("Invalid from Idlestate to insertCard");
    }

    @Override
    public void enterAmountAndPinState() {
        System.out.println("Invalid from Idlestate to enter-amt-and-pin");
    }

    @Override
    public void dispenseCash() {
        System.out.println("Invalid from Idlestate to dispense");
    }

    @Override
    public void ejectCard() {
        System.out.println("Invalid from Idlestate to eject");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Invalid from Idlestate to cancel");
    }

    @Override
    public AtmState getState() {
        return AtmState.IDLE;
    }

    private double generateTransaction() {
        return Math.random();
    }
}
