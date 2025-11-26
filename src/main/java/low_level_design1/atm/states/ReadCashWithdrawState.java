package low_level_design1.atm.states;

import low_level_design1.atm.backendApis.NodeBackendApi;
import low_level_design1.atm.factories.CardManagerFactory;
import low_level_design1.atm.models.Card;
import low_level_design1.atm.enums.ATMState;
import low_level_design1.atm.models.Atm;
import low_level_design1.atm.services.CardManagerService;

public class ReadCashWithdrawState implements StateInterface {
    private final Atm atm;

    public ReadCashWithdrawState(Atm atm) {
        this.atm = atm;
    }
    @Override
    public boolean readCashWithdrawlDetails(Card card,int trId,int amount) {
       // how much amount of cash
        CardManagerService managerService= CardManagerFactory.getCardManager(card.getCardType());
        boolean isWithdrawValid=managerService.validateWithdrawl(trId,amount);
        if(isWithdrawValid)
            this.atm.changeState(new DispenseCashState(atm));
        else
            this.atm.changeState(new EjectCardState(atm));
        return isWithdrawValid;
    }

    @Override
    public boolean cancelTransaction(int traId){
        this.atm.changeState(new ReadyForTransactionState(atm));
        return true;
    }

    @Override
    public int startTransaction() {
        throw new IllegalStateException("ATM is currently busy with other transaction");
    }


    @Override
    public boolean readCardDetailsAndPin(Card card,String pin) {
        throw new IllegalStateException("ATM is currently busy with other transaction");
    }

    @Override
    public int dispenseCash(Card card,int amt,int trId) {
        throw new IllegalStateException("ATM is currently busy with other transaction");
    }

    @Override
    public boolean ejectCard() {
        throw new IllegalStateException("ATM is currently busy with other transaction");
    }

    @Override
    public ATMState getState() {
        return ATMState.READ_CASH_WITHDRW_DETAILS;
    }
}
