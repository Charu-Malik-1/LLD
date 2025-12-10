package low_level_design1.my_atm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import low_level_design1.my_atm.enums.AtmState;
import low_level_design1.my_atm.states.StateInterface;

@Getter
@Setter
public class Atm {
    private final int atmId;
    private AtmState atmState;
    private StateInterface currentState;  // ← Added this

    public Atm(int atmId){
        this.atmId=atmId;
        atmState=AtmState.IDLE;
    }
    public void changeState(StateInterface stateInterface){
        this.atmState=stateInterface.getState();
    }
    // ← Added these delegate methods:
    public int startTransaction() {
        return currentState.startTransaction();
    }

    public boolean readCardDetailsAndPin(Card card, int pin, int txId) {
        return currentState.readCardDetailsAndPin(card, pin, txId);
    }

    public boolean readCashWithdrawDetails(int amount, int txId) {
        return currentState.readCashWithdrawDetails(amount, txId);
    }

    public int dispenseCash(int txId, int amount) {
        return currentState.dispenseCash(txId, amount);
    }

    public boolean ejectCard() {
        return currentState.ejectCard();
    }

    public void cancelTransaction(int trId) {
        currentState.cancelTransaction(trId);
    }
}
