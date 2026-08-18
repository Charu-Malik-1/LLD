package com.lld.atm.atm.lld.practice.state;

import com.lld.atm.atm.lld.practice.models.Atm;
import com.lld.atm.atm.lld.practice.models.Card;

public class IdleState extends IAtmState {

    @Override
    public void insertCard(Atm atm, Card card) {
        if(atm.getCardReader().readCard(card)){
            atm.setInsertedCard(card);
            atm.setCurrentAtmState(new HasCardState());
            atm.getScreen().showMessage("pls enter ur pin");
        }else{
            atm.getScreen().showMessage("card reading failed");
        }
    }
}
