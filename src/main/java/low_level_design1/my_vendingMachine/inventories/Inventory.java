package low_level_design1.my_vendingMachine.inventories;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import low_level_design1.my_vendingMachine.model.Product;

import java.util.*;

@Getter
public class Inventory {
    private Map<Integer, Product> aiselToProductMapping;
    private HashMap<Integer, Integer> productIdToQtyMapping;
    Queue<Integer> availableAisel;

    public Inventory(int totalAvailableAisel) {
        productIdToQtyMapping = new HashMap<>();
        aiselToProductMapping = new HashMap<Integer, Product>();
        availableAisel = new LinkedList<>();
        for (int i = 1; i <= totalAvailableAisel; i++) {
            availableAisel.add(i);
        }
    }

    public void addProduct(Product p) {
        int availableQty = 0;
        if (productIdToQtyMapping.containsKey(p.getId())) {
            availableQty = productIdToQtyMapping.get(p.getId());
            availableQty++;
            productIdToQtyMapping.put(p.getId(), availableQty);
        } else {
            int aiselId = availableAisel.poll();
            aiselToProductMapping.put(aiselId, p);
            productIdToQtyMapping.put(p.getId(), availableQty);
        }
    }

    // remove the product from aisel and reduce the qty by 1
    public void removeProduct(Product p) {
        int id = p.getId();
        if (productIdToQtyMapping.containsKey(id)) {
            int qty = productIdToQtyMapping.get(id);
            if (qty == 1) {
                productIdToQtyMapping.remove(id);
                Iterator<Integer> it=aiselToProductMapping.keySet().iterator();
                for(Map.Entry<Integer, Product> entry: aiselToProductMapping.entrySet()){
                    if(entry.getValue().getId()==id){
                        int aiselNum=entry.getKey();
                        aiselToProductMapping.remove(aiselNum);
                        availableAisel.add(aiselNum);
                    }
                }
            }
        } else {
            System.out.println("Product not found");
        }
    }
}
