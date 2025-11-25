package low_level_design1.vending_machine;

import org.springframework.security.core.parameters.P;

public class Driver {
    public static void main(String[] args){
        System.out.println("ddd");
        VendingMachine vm=new VendingMachine();
        Product herKeys=new Product("herkey",1,5.0);

        //insert 3 herkey
        for(int i=1;i<=3;i++){
            vm.addProduct(herKeys);
        }

        Product biskFarm=new Product("biskfarm",2,2.0);
        for(int i=1;i<=3;i++){
            vm.addProduct(biskFarm);
        }

        vm.insertCoin(5.0);
        vm.insertCoin(3.0);
        vm.pressButton(1);
        vm.insertCoin(5.0);
        vm.pressButton(1);
        vm.insertCoin(7.0);
        vm.pressButton(2);
    }
}
