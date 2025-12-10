package low_level_design1.my_atm.apis;

import low_level_design1.my_atm.model.Card;

public class NodeBackendApi implements BackendApi{

    public int startTransaction(){
        return (int)Math.random();
    }

    @Override
    public boolean validateCardDetails(Card card, int pin, int txnId){
        return true;
    }

    @Override
    public boolean validateAmount(int amount,int txId){
       return true;
    }

    @Override
    public boolean dispenseCash(int txId,int am){
        return true;
    }
}
