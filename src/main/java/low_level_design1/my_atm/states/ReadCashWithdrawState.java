package low_level_design1.my_atm.states;

import low_level_design1.my_atm.enums.AtmState;
import low_level_design1.my_atm.model.Atm;
import low_level_design1.my_atm.model.Card;
import low_level_design1.my_atm.services.ICardService;
import low_level_design1.my_atm.services.ICashDispenseService;

public class ReadCashWithdrawState implements StateInterface {
    private final Atm atm;
    private final ICardService cardService;
    private final ICashDispenseService cashDispenseService;

    public ReadCashWithdrawState(Atm atm,ICardService cs,ICashDispenseService cd) {
        this.atm = atm;
        cardService = cs;
        cashDispenseService=cd;
    }

    @Override
    public boolean readCashWithdrawDetails(int amount,int txId) {
        // check with bank server, if bank atm has sufficient amt
        //check with bank server, if user account has sufficient amt or not
        boolean isAmountValidated=cardService.validateAmount(amount,txId);
        if(isAmountValidated)
            atm.changeState(new DispenseCashState(atm,cashDispenseService));
        else
            atm.changeState(new EjectCardState(atm));
        return false;
    }

    @Override
    public boolean readCashWithdrawDetails(int amount) {
        return false;
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
