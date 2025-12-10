package low_level_design1.my_atm.model;

import lombok.Getter;
import low_level_design1.my_atm.enums.CardType;

@Getter
public class Card {
    private CardType cardType;

    public Card(CardType cardType) {
        this.cardType = cardType;
    }
}
