package com.lld.vending_machine.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rack {
    private int rackId;
    private Product product;
    private int qty;

    public Rack(int id) {
        rackId = id;
    }

    public void loadProduct(Product p, int qty) {
        product = p;
        this.qty = qty;
    }

    public boolean isProductAvailable(){
        if(qty>0)
            return true;
        return false;
    }

    public boolean dispenseProduct() {
        if (qty > 0) {
            qty--;
            System.out.println("product dispensed");
            return true;
        } else {
            System.out.println("product not avaialble");
            return false;
        }
    }
}
