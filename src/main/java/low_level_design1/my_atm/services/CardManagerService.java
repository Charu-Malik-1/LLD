package low_level_design1.my_atm.services;

import low_level_design1.my_atm.model.Card;

public interface CardManagerService {

    public boolean validateCardDetails(Card card, int pin, int txnId) ;

    public boolean validateWithdrawl(int txId,int amount) ;
    public boolean doTransaction(Card card,int amount,int txId) ;
}
