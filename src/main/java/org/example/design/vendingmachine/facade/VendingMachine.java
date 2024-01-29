package org.example.design.vendingmachine.facade;

import org.example.design.vendingmachine.data.Bucket;
import org.example.design.vendingmachine.data.Coin;
import org.example.design.vendingmachine.data.Item;
import org.example.design.vendingmachine.data.exception.SoldOutException;

import java.util.List;

/** * Decleare public API for Vending Machine * @author Javin Paul
 * */    //api of a vending machine

public interface VendingMachine {

    public long selectItemAndGetPrice(Item item) throws SoldOutException;
    public void insertCoin(Coin coin);
    public List<Coin> refund();
    public Bucket<Item, List<Coin>> collectItemAndChange();
    public void reset();

}
