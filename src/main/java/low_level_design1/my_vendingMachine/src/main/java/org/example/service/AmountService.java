package org.example.service;

import lombok.Getter;
import org.example.model.Product;

@Getter
public class AmountService {

    private int currentAmount;

    public void insertCoin(int coin){
        currentAmount+=coin;
    }

    public boolean hasEnoughAmount(int price){
        return currentAmount>=price;
    }

    public int calculateRemainingAmount(int price){
        return currentAmount-price;
    }

    public void deductAmount(int price){
        currentAmount-=price;
    }

    public void reset(){
        currentAmount=0;
    }

}
