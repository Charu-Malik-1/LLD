package com.lld.atm.atm.lld.practice.models;


import com.lld.atm.atm.lld.practice.state.IAtmState;
import com.lld.atm.atm.lld.practice.state.IdleState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Atm {
    private int id;
    private IAtmState currentAtmState;
    private int atmBalance;
    private static Atm instance;

    private CardReader cardReader;
    private CashDispenser cashDispenser;
    private Keypad keypad;
    private Screen screen;
    private Printer printer;

    // session varaible
    private User user;
    private Card insertedCard;
    private boolean authenticated;

    public static Atm getInstance(int id, int amt) {
        if (instance == null) {
            synchronized (Atm.class) {
                if (instance == null) {
                    Atm a = new Atm(id, amt);
                    instance = a;
                }
            }
        }
        return instance;
    }

    private Atm(int id, int amount) {
        this.id = id;
        currentAtmState = new IdleState();
        cardReader = new CardReader();
        cashDispenser = new CashDispenser();
        keypad = new Keypad();
        screen = new Screen();
        printer = new Printer();
    }

    public void setActiveUser(User user) {
        this.user = user;
    }

    public void changeState(IAtmState atmState) {
        currentAtmState = atmState;
    }


}
