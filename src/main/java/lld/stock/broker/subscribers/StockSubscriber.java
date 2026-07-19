package lld.stock.broker.subscribers;

import lld.stock.broker.StockValue;
import lld.stock.broker.enums.StockSymbol;
import lld.stock.broker.model.Value;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * At this point subscriber dont have data of publisher
 * */
public class StockSubscriber implements Subscriber {
    Map<StockSymbol, StockValue> stockData;// this is working as in-memory db

    public StockSubscriber() {
        stockData = new HashMap<>();
    }

    @Override
    public void update(Value value, StockSymbol stockSymbol, Date newTimestamp) {
        if(!stockData.containsKey(stockSymbol)){
            stockData.put(stockSymbol,new StockValue(value,newTimestamp));
        }else if(stockData.get(stockSymbol).getTimestamp().before(newTimestamp)){
            stockData.put(stockSymbol,new StockValue(value,newTimestamp));
        }else{
            System.out.println("Ignoring old data for stocks "+stockSymbol);
        }
    }

    public void displayStockData(){
        for(Map.Entry<StockSymbol,StockValue> entry:stockData.entrySet()){
            Value value=entry.getValue().getValue();
            System.out.println("stock: "+entry.getKey()+" amount="+value.getAmount()+
                    " currency"+value.getCurrency()+
                    " timestamp="+entry.getValue().getTimestamp());
        }
    }
}
