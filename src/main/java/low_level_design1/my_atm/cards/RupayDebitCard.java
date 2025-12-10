package low_level_design1.my_atm.cards;

import low_level_design1.my_atm.enums.CardType;
import low_level_design1.my_atm.model.Card;

public class RupayDebitCard extends Card implements DebitCard,RupayCard{
    public RupayDebitCard(CardType cardType) {
        super(cardType);
    }
}
