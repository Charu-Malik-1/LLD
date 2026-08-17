package com.lld.atm.atm.lld.practice;

import com.lld.atm.atm.lld.practice.enums.CardType;
import com.lld.atm.atm.lld.practice.models.Atm;
import com.lld.atm.atm.lld.practice.models.Card;
import com.lld.atm.atm.lld.practice.service.CardService;

public class Runner {
    public static void runner() {
        CardService cardService = new CardService();
        Atm atm = Atm.getInstance(1, 100000, cardService);
        atm.startTransaction();
        Card card = new Card("123", CardType.RUPAY);
        atm.insertCard(card);
        atm.enterAmountAndPinState(1000, 123);
        atm.dispenseCash();
        atm.ejectCard();


    }
}
