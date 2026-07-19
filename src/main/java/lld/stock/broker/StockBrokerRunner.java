package lld.stock.broker;

import lld.stock.broker.enums.Currency;
import lld.stock.broker.enums.StockSymbol;
import lld.stock.broker.model.Value;
import lld.stock.broker.publishers.ExchangePublisher;
import lld.stock.broker.publishers.IndianStockExchangePublisher;
import lld.stock.broker.subscribers.StockSubscriber;
import lld.stock.broker.subscribers.Subscriber;

import java.util.Date;

public class StockBrokerRunner {
    public static void runner(){
        ExchangePublisher nse=new IndianStockExchangePublisher("NSE");
        ExchangePublisher bse=new IndianStockExchangePublisher("BSE");

        Subscriber s1=new StockSubscriber();

        nse.subscriber(s1);
        bse.subscriber(s1);

        nse.notify(new Value(Currency.INR,100) ,StockSymbol.GOOGLE,new Date());
        bse.notify(new Value(Currency.INR,200) ,StockSymbol.APPLE,new Date()); // new price of google
//        s1.displayStockData();
        bse.notify(new Value(Currency.INR,150) ,StockSymbol.GOOGLE,
                new Date(System.currentTimeMillis()-100000)); //old price of google
        s1.displayStockData();
    }
}
