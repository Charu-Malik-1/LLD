package low_level_design1.my_atm.states;

import low_level_design1.my_atm.enums.AtmState;
import low_level_design1.my_atm.model.Atm;
import low_level_design1.my_atm.model.Card;

public class DispenseCashState implements StateInterface {
    private final Atm atm;

    public DispenseCashState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public int dispenseCash(int traId, int amount) {

        // deduct cash from account and atm
        //service will check for balance from bank server
        // TODO IMP this was we get the services , all services should attach to ATM, not pass from 1 state to other
        boolean isDispenseSuccess = atm.getCashDispenseService().dispenseCash(atm, traId, amount);
        if (isDispenseSuccess) {
            System.out.println("dispense success");
            atm.changeState(new EjectCardState(atm));
            return amount;
        } else {
            System.out.println("dispense success");
            atm.changeState(new EjectCardState(atm));
        }
        return -1;
    }

    @Override
    public int startTransaction(Card card, int amt) {
        throw new IllegalStateException("invalid state at this point");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, int pin, int txId) {
        return false;
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int amount, int txId) {
        return false;
    }

    @Override
    public boolean ejectCard() {
        return false;
    }

    @Override
    public AtmState getState() {
        return AtmState.DISPENSE_CASH;
    }

    @Override
    public boolean cancelTransaction(int trId) {
        atm.changeState(new ReadyForTransactionState(atm));
        return true;
    }
}
