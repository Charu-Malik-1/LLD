package low_level_design1.atm.states;

import low_level_design1.atm.backendApis.NodeBackendApi;
import low_level_design1.atm.dto.CreateTransactionDTO;
import low_level_design1.atm.models.Card;
import low_level_design1.atm.enums.ATMState;
import low_level_design1.atm.models.Atm;

public class ReadyForTransactionState implements StateInterface {
    private final Atm atm;
    private final NodeBackendApi nodeBackendApi;  //-- replace witg BackendApi

    public ReadyForTransactionState(Atm atm) {
        this.atm = atm;
        this.nodeBackendApi = new NodeBackendApi();
    }

    @Override
    public int startTransaction() {

        //if we add new keyword in code , it will cause tight coupling issue later,
        // as constructor can change anytime
        // use factory pattern instead
        CreateTransactionDTO createTransactionDTO=new CreateTransactionDTO(atm.getAtmId());
        int trId=nodeBackendApi.createTransaction(atm.getAtmId());
        if(trId==0)
            throw new RuntimeException("TRansaction cannot be created");
        atm.changeState(new ReadCardDetailsAndPinState(atm));
        return trId;
    }

    @Override
    public boolean cancelTransaction(int traId){
        throw new IllegalStateException("Cannot cancel the tran ");
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
    public int dispenseCash(Card card,int amt,int trId) {
        throw new IllegalStateException("ATM is currently busy with other transaction");
    }

    @Override
    public boolean ejectCard() {
        throw new IllegalStateException("ATM is currently busy with other transaction");
    }

    @Override
    public ATMState getState() {
        return ATMState.READY_FOR_TRANSACTION;
    }


}
