package low_level_design1.my_atm.cards;

import low_level_design1.my_atm.enums.CardType;
import low_level_design1.my_atm.model.Card;

public class RupayCreditCard extends Card implements CreditCard,RupayCard{
    public RupayCreditCard(CardType cardType) {
        super(cardType);
    }
}
