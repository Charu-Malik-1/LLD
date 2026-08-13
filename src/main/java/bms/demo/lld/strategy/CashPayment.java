package bms.demo.lld.strategy;

public class CashPayment implements IPaymentStrategy {
    @Override
    public boolean makePayment() {
        return true;
    }
    @Override
    public boolean refund() {
        System.out.println("Refunding...");
        return true;
    }
}
