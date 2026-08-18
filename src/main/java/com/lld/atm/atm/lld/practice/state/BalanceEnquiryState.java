package com.lld.atm.atm.lld.practice.state;

import com.lld.atm.atm.lld.practice.models.Atm;
import com.lld.atm.atm.lld.practice.models.Card;

public class BalanceEnquiryState extends IAtmState {

    @Override
    public void displayBalance(Atm atm, Card card) {
        double balance = atm.getUser().getBankAccount().getAvaialbleBalance();
        atm.getScreen().showMessage("ur current balance is=" + balance);
        atm.setCurrentAtmState(new SelectOperationState());
    }
}
