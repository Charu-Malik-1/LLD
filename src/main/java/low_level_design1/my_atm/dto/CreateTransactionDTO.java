package low_level_design1.my_atm.dto;

import lombok.Getter;
import low_level_design1.my_atm.model.Card;

@Getter
public class CreateTransactionDTO {
    private int atmId;
    private Card card;
    private int amount;
    public CreateTransactionDTO(int atmId,Card card, int amount){
        this.atmId=atmId;
        this.card=card;
        this.amount=amount;
    }
}
