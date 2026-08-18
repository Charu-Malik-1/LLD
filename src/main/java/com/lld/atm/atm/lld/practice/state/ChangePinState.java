package com.lld.atm.atm.lld.practice.state;

import com.lld.atm.atm.lld.practice.models.Atm;
import com.lld.atm.atm.lld.practice.models.Card;

public class ChangePinState extends IAtmState {

    @Override
    public void changePin(Atm atm, Card card, int newPin) {
        card.setPin(newPin);
        atm.getScreen().showMessage("PIN changed.");
        // Return to selection state
        atm.setCurrentAtmState(new SelectOperationState());
    }
}
