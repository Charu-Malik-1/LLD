package com.lld.hotel_management.strategy;

import com.lld.hotel_management.models.Payment;

public interface PaymentStrategy {

    Payment makePayment(int amount);
}
