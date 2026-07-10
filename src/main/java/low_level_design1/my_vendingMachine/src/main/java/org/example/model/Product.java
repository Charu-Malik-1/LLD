package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int itemId;
    private String itemName;
    private int price;

    public Product(int itemId,String itemName,int price){
        this.itemId=itemId;
        this.itemName=itemName;
        this.price=price;
    }
}
