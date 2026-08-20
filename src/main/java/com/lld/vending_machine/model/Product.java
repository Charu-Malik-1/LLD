package com.lld.vending_machine.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {

    private int productId;
    private String productName;
    private int price;

    public Product(int id, String name, int price) {
        productId = id;
        productName = name;
        this.price = price;
    }
}
