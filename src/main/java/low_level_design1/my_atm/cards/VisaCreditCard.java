package low_level_design1.my_atm.cards;

import low_level_design1.my_atm.enums.CardType;
import low_level_design1.my_atm.model.Card;

public class VisaCreditCard extends Card implements CreditCard,VisaCard{
    public VisaCreditCard(CardType cardType) {
        super(cardType);
    }
}
