package com.lld.hotel_management.models;

import com.lld.hotel_management.enums.PaymentMode;

public class Payment {
    int paymentId;
    PaymentMode paymentMode;
    int amount;

    public Payment(int p, PaymentMode paymentMode, int amount) {
        this.paymentId = p;
        this.paymentMode = paymentMode;
        this.amount = amount;
    }
}
