package low_level_design1.my_atm.states;

import low_level_design1.my_atm.enums.AtmState;
import low_level_design1.my_atm.model.Atm;
import low_level_design1.my_atm.model.Card;

public class EjectCardState implements StateInterface{
    private final Atm atm;
    public EjectCardState(Atm atm){
        this.atm=atm;
    }

    @Override
    public int startTransaction() {
        return 0;
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, int pin,int txId) {
        return false;
    }

    @Override
    public boolean readCashWithdrawDetails(int amount, int txId) {
        return false;
    }

//    @Override
    public boolean readCashWithdrawDetails(int amount) {
        return false;
    }

    @Override
    public int dispenseCash(int traId, int amount) {
        return 0;
    }

    @Override
    public boolean ejectCard() {
        return false;
    }

    @Override
    public AtmState getState() {
        return null;
    }

    @Override
    public void cancelTransaction(int trId) {

    }
}
