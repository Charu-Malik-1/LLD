package com.lld.atm.atm.lld.practice.models;

import lombok.Getter;

@Getter
public class User {
    private Card card;
    private BankAccount bankAccount;

    public User(BankAccount account,Card card){
        bankAccount=account;
        this.card=card;
    }


}
