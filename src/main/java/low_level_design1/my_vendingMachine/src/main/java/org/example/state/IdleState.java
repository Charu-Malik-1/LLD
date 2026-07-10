package org.example.state;

import org.example.model.VendingMachine;

public class IdleState implements StateInterface{
    VendingMachine vm;

    public IdleState(VendingMachine vm){
        this.vm=vm;
    }
    @Override
    public void insertCoin(int coin) {
        System.out.println("pls select the item fisrt");
    }

    @Override
    public void selectItem(int itemNum) {
        if(vm.getInventoryService().isItemAvailable(itemNum)){
            vm.setCurrentItem(itemNum);
            vm.setCurrentState(new NoCoinState(vm));
        }else{
            System.out.println("No item available");
            vm.setCurrentState(new IdleState(vm));
        }
    }

    @Override
    public void dispenseItem(int item) {

    }

    @Override
    public void returnCoin() {

    }
}
