package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Inventory {
    private Map<Integer, Product> aiselToProductMapping;
    private Map<Integer, Integer> productIdToQuantityMapping;
    private Queue<Integer> availableAisel;

    public Inventory(int totalAvailableAisel) {
        productIdToQuantityMapping = new HashMap<>();
        aiselToProductMapping = new HashMap<>();
        availableAisel = new LinkedList<>();

        for (int i = 1; i <= totalAvailableAisel; i++) {
            availableAisel.add(i);
        }
    }

    public Product getProductFromItemId(int itemId){
        Iterator<Map.Entry<Integer,Product>> it = aiselToProductMapping.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Product> entry = it.next();
            if(entry.getValue().getItemId()==itemId){
                return entry.getValue();
            }
        }
        return null;
    }

    public void addProductToInventory(Product p) {
        if (productIdToQuantityMapping.containsKey(p.getItemId())) {
            productIdToQuantityMapping.put(p.getItemId(), p.getItemId() + 1);
        } else {
            int aiselId = availableAisel.poll();
            productIdToQuantityMapping.put(p.getItemId(), 1);
            aiselToProductMapping.put(aiselId, p);
        }
    }

    public void removeProductFromInventory(Product p) {
        int id = p.getItemId();
        if (productIdToQuantityMapping.containsKey(id)) {
            int qty = productIdToQuantityMapping.get(id);
            if (qty == 1) {
                productIdToQuantityMapping.remove(id);
                Iterator<Map.Entry<Integer,Product>> it = aiselToProductMapping.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, Product> entry = it.next();
                    if (entry.getValue().getItemId() == id) {
                        int aiselNum = entry.getKey();
                        aiselToProductMapping.remove(aiselNum);
                        availableAisel.add(aiselNum);
                    }
                }
            }else
            {
                productIdToQuantityMapping.put(id,qty-1);
            }
        } else {
            System.out.println("Product not found");
        }
    }
}
