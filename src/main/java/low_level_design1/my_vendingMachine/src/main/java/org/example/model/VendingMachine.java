package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.service.AmountService;
import org.example.service.InventoryService;
import org.example.state.IdleState;
import org.example.state.NoCoinState;
import org.example.state.StateInterface;

@Getter
@Setter
public class VendingMachine {
    private static VendingMachine instance;
    private StateInterface currentState;
    private int currentAmount;
    private int currentItem;
    private final InventoryService inventoryService;
    private final AmountService amountService;

    public static VendingMachine getInstace(InventoryService inventoryService, AmountService amountService) {
        instance = new VendingMachine(inventoryService, amountService);
        return instance;
    }

    private VendingMachine(InventoryService inventoryService, AmountService amountService) {
        currentState = new IdleState(this);
        this.inventoryService = inventoryService;
        this.amountService = amountService;
        this.currentAmount = 0;
        this.currentItem = -1;
    }

    /**
     * User Operations
     */
    public void selectItem(int itemNum) {
        currentState.selectItem(itemNum);
    }

    public void insertCoin(int coin) {
        amountService.insertCoin(coin);
        currentState.insertCoin(coin);
    }


    /**
     * Machine Operations
     */
    public int dispenseItem(int itemNum) {

        Product p=inventoryService.findProductWithItemNum(itemNum);
        inventoryService.reduceProductFromInventory(itemNum);

        int amount = amountService.calculateRemainingAmount(p.getPrice());
        return amount;
    }


}
