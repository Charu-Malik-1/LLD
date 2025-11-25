package low_level_design1.vending_machine;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Inventory {
    private Map<Integer,Product> aisleToProductMap;
    private Map<Integer,Integer> productToCountMap;
    Queue<Integer> availableAisel;

    public Inventory(int aisleCount){
        availableAisel=new LinkedList<>();
        for(int i=1;i<=aisleCount;i++){
            availableAisel.add(i);
        }
        aisleToProductMap=new HashMap<Integer,Product>();
        productToCountMap=new HashMap<>();
    }

    // add 1 item to aisel
    public void addProduct(Product product) throws Exception{
        int prodId= product.getId();
        int productCount=productToCountMap.getOrDefault(prodId,0);
        if(productCount==0){
            // no ailes avaiable to add product
            if(availableAisel.isEmpty()){
                throw new Exception("Out of space to add aisel");
            }
            else{
                aisleToProductMap.put(availableAisel.poll(), product);
            }
        }
        productToCountMap.put(prodId,productCount+1);
    }

    public Product getProductAt(int aiselNum){
        return aisleToProductMap.get(aiselNum);
    }

    public boolean checkIfProductAvailable(int prodId){
        int pId=productToCountMap.getOrDefault(prodId,-1);
        return pId>0;
    }

    public void deductProductCount(int aisleNum){
        Product p=aisleToProductMap.get(aisleNum);
        int updateProductCount=productToCountMap.get(p.getId());
        if(updateProductCount==0) // stock of product is finish hence aisle available
        {
            productToCountMap.remove(p.getId());
            aisleToProductMap.remove(aisleNum);
            availableAisel.add(aisleNum);
        }else{
            productToCountMap.put(p.getId(),updateProductCount);
        }
    }

}
