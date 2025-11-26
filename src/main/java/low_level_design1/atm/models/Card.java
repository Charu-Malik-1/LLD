package low_level_design1.atm.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import low_level_design1.atm.enums.CardType;

@Getter
@Setter
@AllArgsConstructor
public class Card {
    private final String cardNum;
    private final CardType cardType;
    private final int pin;
    private final String name;
    private final String bankName;
}
