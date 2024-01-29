package org.example.design.vendingmachine.factory;

import org.example.design.vendingmachine.data.VendingMachineImpl;
import org.example.design.vendingmachine.facade.VendingMachine;

/*
 Factory class to create instance of Vending Machine, * this can be extended to create instance of * different types of vending machines.
*/
public class VendingMachineFactory {

    public static VendingMachine createVendingMachine(){
        return new VendingMachineImpl();
    }


}
