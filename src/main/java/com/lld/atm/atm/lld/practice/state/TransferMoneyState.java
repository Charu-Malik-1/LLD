package com.lld.atm.atm.lld.practice.state;

import com.lld.atm.atm.lld.practice.models.Atm;
import com.lld.atm.atm.lld.practice.models.BankAccount;
import com.lld.atm.atm.lld.practice.models.Card;

public class TransferMoneyState extends IAtmState {
    @Override
    public void transferMoney(Atm atm, Card card, BankAccount bankAccount,double amt){

        atm.getScreen().showMessage("transfere money suuccess.");
        // Return to selection state

        atm.setCurrentAtmState(new SelectOperationState());
    }
}
