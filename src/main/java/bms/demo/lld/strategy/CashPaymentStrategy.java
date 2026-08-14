package bms.demo.lld.strategy;

public class CashPaymentStrategy implements IPaymentStrategy {
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
