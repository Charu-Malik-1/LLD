package com.lld.atm.atm.lld.practice.state;

import com.lld.atm.atm.lld.practice.models.Atm;
import com.lld.atm.atm.lld.practice.models.BankAccount;
import com.lld.atm.atm.lld.practice.models.Card;
import com.lld.atm.atm.lld.practice.enums.TransactionType;

public abstract class IAtmState {

    public void insertCard(Atm atm, Card card) {}
    public void authenticatePin(Atm atm, Card card, int pin) {}
    public void selectOperation(Atm atm, TransactionType tType) {}
    public void cashWithdrawal(Atm atm, Card card, double amount) {}
    public void displayBalance(Atm atm, Card card) {}
    public void transferMoney(Atm atm, Card card, BankAccount toAccount, double amount) {}
    public void changePin(Atm atm, Card card, int newPin) {}
    public void cancelTransaction(Atm atm) {}
    public void returnCard(Atm atm) {}
}
