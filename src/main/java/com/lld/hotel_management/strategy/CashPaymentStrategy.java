package com.lld.hotel_management.strategy;

import com.lld.hotel_management.enums.PaymentMode;
import com.lld.hotel_management.models.Payment;

public class CashPaymentStrategy implements PaymentStrategy{

    @Override
    public Payment makePayment(int amount) {
        return new Payment(1, PaymentMode.CASH,amount);
    }
}
