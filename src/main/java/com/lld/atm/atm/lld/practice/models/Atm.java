package com.lld.atm.atm.lld.practice.models;

import com.lld.atm.atm.lld.practice.service.CardService;
import com.lld.atm.atm.lld.practice.state.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Atm {
    private int id;
    private IAtmState currentAtmState;
    private int amount;
    private static Atm instance;
    private Transaction currentTransaction;
    private final CardService cardService;

    public static Atm getInstance(int id, int amt,CardService cardService) {
        if (instance == null) {
            synchronized (Atm.class) {
                if (instance == null) {
                    Atm a = new Atm(id, amt,cardService);
                    instance = a;
                }
            }
        }
        return instance;
    }

    private Atm(int id, int amount,CardService cardService) {
        this.id = id;
       this.amount=amount;
       this.cardService=cardService;
    }

    public void startTransaction(){
        setCurrentAtmState(new ReadyForTransactionState(this));
        currentAtmState.startTransaction();
    }

    public void insertCard(Card card) {
        currentTransaction.setCard(card);
        currentAtmState.insertCard();
    }


    public void enterAmountAndPinState(int amount, int pin) {
        currentTransaction.setPin(pin);
        currentTransaction.setAmount(amount);
        currentAtmState.enterAmountAndPinState();
    }

    public void dispenseCash() {
        currentAtmState.dispenseCash();
    }

    public void ejectCard() {
        currentAtmState.ejectCard();
    }

    public void cancelTransaction() {

    }

    public void changeState(IAtmState atmState) {
        currentAtmState=atmState;
    }


}
