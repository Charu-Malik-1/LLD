package low_level_design1.my_atm.dto;

import low_level_design1.my_atm.model.Card;

public class ValidateCardDetailsDTO {
    private final Card card;
    private final int pin;
    private final int transactionId;

    public ValidateCardDetailsDTO(Card card, int pin, int txnId) {
        this.pin = pin;
        this.transactionId = txnId;
        this.card = card;
    }
}
