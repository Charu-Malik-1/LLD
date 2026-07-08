package low_level_design1.my_vendingMachine.services;

import lombok.Getter;
import lombok.Setter;
import low_level_design1.my_vendingMachine.inventories.Inventory;
import low_level_design1.my_vendingMachine.model.Product;

@Getter
@Setter
public class InventoryService {

    private Inventory inventory;

    public InventoryService(Inventory inventory) {
        this.inventory = inventory;
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
