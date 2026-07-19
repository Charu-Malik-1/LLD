package lld.stock.broker.publishers;

import lld.stock.broker.enums.StockSymbol;
import lld.stock.broker.model.Value;
import lld.stock.broker.subscribers.Subscriber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class IndianStockExchangePublisher implements ExchangePublisher {
    private List<Subscriber> subscribers;
    private final String exchangeName;

    public IndianStockExchangePublisher(String exchangeName) {
        this.exchangeName = exchangeName;
        subscribers = new ArrayList<>();
    }

    public void subscriber(Subscriber s) {
        subscribers.add(s);
    }

    public void unsubscriber(Subscriber s) {
        subscribers.remove(s);
    }

    public void notify(Value value, StockSymbol stockSymbol, Date date) {
        for (Subscriber s : subscribers) {
            s.update(value, stockSymbol,date);
        }
    }
}
