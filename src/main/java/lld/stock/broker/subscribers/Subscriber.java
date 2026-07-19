package lld.stock.broker.subscribers;

import lld.stock.broker.enums.StockSymbol;
import lld.stock.broker.model.Value;

import java.util.Date;

public interface Subscriber {
    void update(Value value, StockSymbol stockSymbol, Date newTimestamp);
     void displayStockData();
}
