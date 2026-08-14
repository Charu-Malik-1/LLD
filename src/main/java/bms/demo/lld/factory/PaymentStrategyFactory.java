package bms.demo.lld.factory;

import bms.demo.lld.enums.PaymentMethod;
import bms.demo.lld.strategy.CardPaymentStrategy;
import bms.demo.lld.strategy.CashPaymentStrategy;
import bms.demo.lld.strategy.IPaymentStrategy;

public class PaymentStrategyFactory {

    public static IPaymentStrategy create(PaymentMethod method) {
        IPaymentStrategy paymentStrategy = null;
        switch (method) {
            case CASH -> paymentStrategy = new CashPaymentStrategy();
            case CREDIT -> paymentStrategy = new CardPaymentStrategy();
        }
        return paymentStrategy;
    }
}
