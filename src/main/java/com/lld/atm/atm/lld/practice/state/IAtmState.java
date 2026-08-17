package com.lld.atm.atm.lld.practice.state;

import com.lld.atm.atm.lld.practice.enums.AtmState;
import com.lld.atm.atm.lld.practice.models.Card;
import com.lld.atm.atm.lld.practice.models.Transaction;

public interface IAtmState {
    void startTransaction();

//    void insertCardAndPin();

//    void insertCardAndPin();

    void insertCard();


    void enterAmountAndPinState();

    void dispenseCash();
    void ejectCard();
    void cancelTransaction();

//    void cancelTransaction(int traId);

//    void cancelTransaction(int traId);
//
    AtmState getState();
}
