package low_level_design1.my_atm.states;

import low_level_design1.my_atm.apis.BackendApi;
import low_level_design1.my_atm.dto.ValidateWithdrawlAmountWithBankDTO;
import low_level_design1.my_atm.enums.AtmState;
import low_level_design1.my_atm.factories.CardManagerFactory;
import low_level_design1.my_atm.model.Atm;
import low_level_design1.my_atm.model.Card;
import low_level_design1.my_atm.services.CardManagerService;
import low_level_design1.my_atm.services.ICashDispenseService;

public class ReadCashWithdrawState implements StateInterface {
    private final Atm atm;

    public ReadCashWithdrawState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int amount, int txId) {

//        ValidateWithdrawlAmountWithBankDTO v=new ValidateWithdrawlAmountWithBankDTO(amount,txId);
        boolean isWithdrawValid = atm.getCardManager(card.getCardType()).validateWithdrawlAmount(atm.getAtmId(),txId, amount);
        if (isWithdrawValid)
            this.atm.changeState(new DispenseCashState(atm));
        else
            this.atm.changeState(new ReadyForTransactionState(atm));
        return isWithdrawValid;

//        // check with bank server, if bank atm has sufficient amt
//        //check with bank server, if user account has sufficient amt or not
//        boolean isAmountValidated = cardService.validateAmount(amount, txId);
//        if (isAmountValidated)
//            atm.changeState(new DispenseCashState(atm, cashDispenseService));
//        else
//            atm.changeState(new EjectCardState(atm));
//        return false;
    }

    @Override
    public int startTransaction(Card card,int amt) {
        throw new IllegalStateException("invalid state at this point");
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
        return AtmState.READ_CASH_WITHDRAW_DETAILS;
    }

    @Override
    public boolean cancelTransaction(int trId) {
        atm.changeState(new ReadyForTransactionState(atm));
        return true;
    }
}
