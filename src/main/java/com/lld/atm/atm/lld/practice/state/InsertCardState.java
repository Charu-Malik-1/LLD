package com.lld.atm.atm.lld.practice.state;

import com.lld.atm.atm.lld.practice.enums.AtmState;
import com.lld.atm.atm.lld.practice.models.Atm;
import com.lld.atm.atm.lld.practice.models.Card;

public class InsertCardState implements IAtmState {
    private Atm atm;

    public InsertCardState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void startTransaction() {
        System.out.println("Invalid from insertcard to start-trans");
    }

//    @Override
//    public void insertCardAndPin() {
//        Card card=atm.getCurrentTransaction().getCard();
//        if(atm.getCardService().validateCard(card)){
//            atm.changeState(new EnterAmountAndPinState(atm));
//        }else{
//            atm.changeState(new CancelTransactionState(atm));
//        }
//    }





    @Override
    public void insertCard() {
        Card card=atm.getCurrentTransaction().getCard();
        if(atm.getCardService().validateCard(card)){
            atm.changeState(new EnterAmountAndPinState(atm));
        }else{
            atm.changeState(new CancelTransactionState(atm));
        }
    }



    @Override
    public void enterAmountAndPinState() {
        System.out.println("Invalid from insertcard to enterAmtandPin");
    }

    @Override
    public void dispenseCash() {
        System.out.println("Invalid from insertcard to dispense");
    }

    @Override
    public void ejectCard() {
        System.out.println("Invalid from insertcard to eject");
    }



    @Override
    public AtmState getState() {
        return AtmState.INSERT_CARD;
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Invalid from insertcard to cancel");
    }
}
