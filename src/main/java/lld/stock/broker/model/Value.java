package lld.stock.broker.model;

import lld.stock.broker.enums.Currency;
import lombok.Getter;

@Getter
public class Value {
    private Currency currency;
    private int amount;

    public Value(Currency currency,int amount){
        this.currency=currency;
        this.amount=amount;
    }
}
