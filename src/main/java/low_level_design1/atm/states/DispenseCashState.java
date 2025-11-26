package low_level_design1.atm.states;

import low_level_design1.atm.backendApis.NodeBackendApi;
import low_level_design1.atm.factories.CardManagerFactory;
import low_level_design1.atm.models.Card;
import low_level_design1.atm.enums.ATMState;
import low_level_design1.atm.models.Atm;
import low_level_design1.atm.services.CardManagerService;
import low_level_design1.atm.services.CashDispenserService;

public class DispenseCashState implements StateInterface {
    private final Atm atm;
    private final CashDispenserService cashDispenserService;

    public DispenseCashState(Atm atm) {
        this.atm = atm;
        this.cashDispenserService=new CashDispenserService();
    }

    @Override
    public int dispenseCash(Card card,int amt,int trId) {
        CardManagerService manager= CardManagerFactory.getCardManager(card.getCardType());
        boolean isTxnSuccess=manager.doTransaction(card,amt,trId);
        if(isTxnSuccess)
        {
            cashDispenserService.dispenseCash(atm,amt);
            atm.changeState(new EjectCardState(atm));
        }else{
            System.out.println("somethig went wrong");
            this.atm.changeState(new EjectCardState(atm));
        }
      return amt;
    }

    @Override
    public boolean cancelTransaction(int trId) {
        throw new IllegalStateException("Cannot cancel the trs while dispensing the cash");
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
    public boolean readCashWithdrawlDetails(Card card,int trId,int amount) {
        throw new IllegalStateException("ATM is currently busy with other transaction");
    }

    @Override
    public boolean ejectCard() {
        throw new IllegalStateException("ATM is currently busy with other transaction");
    }

    @Override
    public ATMState getState() {
        return ATMState.DISPENSING_CASH;
    }


}
