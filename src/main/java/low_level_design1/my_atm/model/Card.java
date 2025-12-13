package low_level_design1.my_atm.model;

import lombok.Getter;
import low_level_design1.my_atm.enums.CardType;

@Getter
public class Card {
    private final String cardNum;
    private CardType cardType;
    private final int pin;
    private final String name;
    private final String bankName ;


    public Card(CardType cardType) {
        this.cardType = cardType;
        cardNum="random num";
        pin=1234;
        name="charu";
        bankName="ixix";
    }
}
