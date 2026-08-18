package com.lld.atm.atm.lld.practice.state;

import com.lld.atm.atm.lld.practice.models.Atm;
import com.lld.atm.atm.lld.practice.models.BankAccount;
import com.lld.atm.atm.lld.practice.models.Card;

public class CashWithdrawlState extends IAtmState {

    @Override
    public void cashWithdrawal(Atm atm, Card card, double amt) {
        BankAccount ba = atm.getUser().getBankAccount();
        if (amt <= ba.getAvaialbleBalance() && amt <= atm.getAtmBalance()) {
            boolean dispense = atm.getCashDispenser().dispenseCash(atm, amt);
            if (dispense) {
                ba.withdraw(amt);
                atm.getPrinter().printReceipt(amt);
                atm.getScreen().showMessage("collect ur cash");
            } else {
                atm.getScreen().showMessage("unavle to dispense the amt");
            }
        } else {
            atm.getScreen().showMessage("check ur balance");
        }
        atm.setCurrentAtmState(new SelectOperationState());
    }
}
