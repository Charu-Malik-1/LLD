package low_level_design1.my_vendingMachine.services;

import low_level_design1.my_vendingMachine.inventories.Inventory;
import low_level_design1.my_vendingMachine.model.Product;

public class InventoryService {
    private Inventory inventory;

    public InventoryService() {
        inventory = new Inventory(5);
    }

    public boolean isItemAvailable(Product p) {
        if (inventory.getProductIdToQtyMapping().containsKey(p.getId()))
            return true;
        return false;
    }

    public Product getItem(int aiselNum){
        return inventory.getAiselToProductMapping().get(aiselNum);
    }

    public void reduceInventory(Product p){
        inventory.removeProduct(p);
    }
}
