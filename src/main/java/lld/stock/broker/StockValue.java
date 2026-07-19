package lld.stock.broker;

import lld.stock.broker.model.Value;
import lombok.Getter;

import java.util.Date;

@Getter
public class StockValue {
    // here we can store list of old stock data
    private final Value value;
    private final Date timestamp;

    public StockValue(Value value, Date timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
