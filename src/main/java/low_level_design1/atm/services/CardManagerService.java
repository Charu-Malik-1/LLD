package low_level_design1.atm.services;

import low_level_design1.atm.models.Card;

public interface CardManagerService {
    boolean validateCard(Card card, String pin);
    boolean validateWithdrawl(int tranId,double amount);
    boolean doTransaction(Card card,double amount,int transactionId);
}
