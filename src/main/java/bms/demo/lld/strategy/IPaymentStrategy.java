package bms.demo.lld.strategy;

public interface IPaymentStrategy {
    boolean makePayment();
    boolean refund();
}
