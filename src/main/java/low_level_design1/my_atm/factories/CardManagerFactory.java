package low_level_design1.my_atm.factories;

import low_level_design1.my_atm.enums.CardType;
import low_level_design1.my_atm.services.CardManagerService;
import low_level_design1.my_atm.services.CreditCardManagerService;
import low_level_design1.my_atm.services.DebitCardManagerService;

public class CardManagerFactory {
    public static CardManagerService getCardManager(CardType cardType){
        CardManagerService cardManagerService=null;
        if(cardType.equals(CardType.DEBIT)){
            cardManagerService=new DebitCardManagerService();
        }else if(cardType.equals(CardType.CREDIT))
        {
            cardManagerService=new CreditCardManagerService();
        }else{
            throw new IllegalStateException("Invalid card type");
        }
        return cardManagerService;
    }
}
