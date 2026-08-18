package com.lld.atm.atm.lld.practice.state;

import com.lld.atm.atm.lld.practice.models.Atm;
import com.lld.atm.atm.lld.practice.models.Card;

public class HasCardState extends IAtmState {
    @Override
    public void authenticatePin(Atm atm, Card card, int pin) {
        if (card.validatePin(pin)) {
            atm.setAuthenticated(true);
            atm.setCurrentAtmState(new SelectOperationState());
            atm.getScreen().showMessage("pin verified");
        } else {
            atm.getScreen().showMessage("incorect pin");
        }
    }

    @Override
    public void returnCard(Atm atm) {
        atm.setInsertedCard(null);
        atm.setAuthenticated(false);
        atm.setCurrentAtmState(new IdleState());
        atm.getScreen().showMessage("Card returned. Thank you.");
    }
}
