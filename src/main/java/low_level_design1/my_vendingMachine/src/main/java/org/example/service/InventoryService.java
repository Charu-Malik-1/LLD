package org.example.service;

import org.example.model.Inventory;
import org.example.model.Product;

public class InventoryService {
    private final Inventory inventory;

    public InventoryService(Inventory inventory) {
        this.inventory = inventory;
    }

    //isproduct avaialble
    //get product
    //reduce inventory
    //add inventory

    public boolean isItemAvailable(int itemNum) {
        Product p = findProductWithItemNum(itemNum);
        if (p == null)
            return false;
        return true;
    }

    public Product findProductWithItemNum(int itemNum) {
        return inventory.getProductFromItemId(itemNum);
    }

    public void reduceProductFromInventory(int itemNum){
        Product p=findProductWithItemNum(itemNum);
        if(p!=null){
            deleteProductFromInventory(p);
        }else{
            System.out.println("Product not found");
        }
    }

    public void deleteProductFromInventory(Product p) {
        inventory.removeProductFromInventory(p);
    }

    public void addProductToInventory(Product p) {
        inventory.addProductToInventory(p);
    }

}
