package com.lld.atm.atm.lld.practice.state;

import com.lld.atm.atm.lld.practice.enums.AtmState;
import com.lld.atm.atm.lld.practice.models.Atm;
import com.lld.atm.atm.lld.practice.models.Card;
import com.lld.atm.atm.lld.practice.models.Transaction;
import com.lld.atm.atm.lld.practice.service.CardService;

public class EnterAmountAndPinState implements IAtmState {
    private CardService cardService;
    private Atm atm;

    public EnterAmountAndPinState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void startTransaction() {
        System.out.println("Invalid from enteramount to start-trans");
    }

    @Override
    public void insertCard() {
        System.out.println("Invalid from enteramount toinsertCard");
    }

    @Override
    public void enterAmountAndPinState() {
        Transaction t = atm.getCurrentTransaction();
        if (atm.getCardService().validatePinAndAmount(t.getPin(), t.getAmount())) {
            atm.changeState(new DispenseCashState(atm));
        } else {
            atm.changeState(new CancelTransactionState(atm));
        }
    }

    @Override
    public void dispenseCash() {
        System.out.println("Invalid from enteramount to dispenseCash");
    }

    @Override
    public void ejectCard() {
        System.out.println("Invalid from enteramount to ejectCard");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Invalid from enteramount to cancelTra");
    }

    @Override
    public AtmState getState() {
        return AtmState.ENTER_AMT_AND_PIN;
    }
}
