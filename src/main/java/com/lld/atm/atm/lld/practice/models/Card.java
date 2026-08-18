package com.lld.atm.atm.lld.practice.models;

import com.lld.atm.atm.lld.practice.enums.CardType;
import lombok.Getter;

@Getter
public class Card {
    private final String cardNumber;
    private final CardType cardType;

    public Card(String cn, CardType cardType) {
        this.cardNumber = cn;
        this.cardType = cardType;
    }

    public boolean validatePin(int pin){
        return true;
    }

    public void setPin(int newPin){

    }
}
