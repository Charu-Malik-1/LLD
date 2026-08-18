package com.lld.atm.atm.lld.practice;

import com.lld.atm.atm.lld.practice.enums.CardType;
import com.lld.atm.atm.lld.practice.enums.TransactionType;
import com.lld.atm.atm.lld.practice.models.Atm;
import com.lld.atm.atm.lld.practice.models.BankAccount;
import com.lld.atm.atm.lld.practice.models.Card;
import com.lld.atm.atm.lld.practice.models.User;


public class Runner {
    public static void runner() {
        Atm atm = Atm.getInstance(1, 100000);

        BankAccount bankAccount = new BankAccount();
        Card card = new Card("123", CardType.RUPAY);
        User user1 = new User(bankAccount, card);

        atm.setActiveUser(user1);
        atm.getCurrentAtmState().insertCard(atm, user1.getCard());
        atm.getCurrentAtmState().authenticatePin(atm, user1.getCard(), 1111);
        atm.getCurrentAtmState().selectOperation(atm, TransactionType.CASH_WITHDRAW);
        atm.getCurrentAtmState().cashWithdrawal(atm, user1.getCard(), 1000);
        atm.getCurrentAtmState().returnCard(atm);
    }
}