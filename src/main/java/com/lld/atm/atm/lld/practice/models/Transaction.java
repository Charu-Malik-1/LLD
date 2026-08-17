package com.lld.atm.atm.lld.practice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private final double id;
    private int amount;
    private Card card;
    private int pin;

    public Transaction(double id) {
        this.id = id;
    }
}
