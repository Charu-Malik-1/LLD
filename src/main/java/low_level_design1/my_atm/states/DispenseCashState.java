package low_level_design1.my_atm.states;

import low_level_design1.my_atm.enums.AtmState;
import low_level_design1.my_atm.model.Atm;
import low_level_design1.my_atm.model.Card;
import low_level_design1.my_atm.services.CashDispenseService;
import low_level_design1.my_atm.services.ICashDispenseService;

public class DispenseCashState implements StateInterface {
    private final Atm atm;
    private final ICashDispenseService cashDispenseService;

    public DispenseCashState(Atm atm,ICashDispenseService c) {
        this.atm = atm;
        cashDispenseService = c;
    }

    @Override
    public int dispenseCash(int traId, int amount) {
        // deduct cash from accoun and atm
        boolean isDispensSuccess=cashDispenseService.dispenseCash(traId,amount);
        if(isDispensSuccess) {
            System.out.println("dispense success");
            atm.changeState(new EjectCardState(atm));
            return amount;
        }else{
            System.out.println("dispense success");
        }
        return -1;
    }

    @Override
    public int startTransaction() {
        return 0;
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, int pin, int txId) {
        return false;
    }

    @Override
    public boolean readCashWithdrawDetails(int amount,int txId) {
        return false;
    }

    @Override
    public boolean readCashWithdrawDetails(int amount) {
        return false;
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
