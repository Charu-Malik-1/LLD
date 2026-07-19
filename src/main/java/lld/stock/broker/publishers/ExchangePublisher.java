package lld.stock.broker.publishers;
import lld.stock.broker.enums.StockSymbol;
import lld.stock.broker.model.Value;
import lld.stock.broker.subscribers.Subscriber;

import java.util.Date;

public interface ExchangePublisher {
    void subscriber(Subscriber s);
    void unsubscriber(Subscriber s);
    void notify(Value value, StockSymbol stockSymbol, Date date);
}
