package org.example.inheritance.money;

import junit.framework.TestCase;
import org.example.design.vendingmachine.money.Bill;
import org.example.design.vendingmachine.money.Coin;
import org.example.design.vendingmachine.money.Money;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CoinTest extends TestCase {

    @Test
    public void testCountMoney(){
        List<Money> moneyList = new ArrayList<>();
        moneyList.add(Coin.DIME);
        moneyList.add(Coin.NICKEL);
        moneyList.add(Bill.DOLLAR);

        Float sum = 0F;
        for (Money money : moneyList) {
            sum = sum + money.getValue();
        }

        Assert.assertEquals("Counting money did not work.", (Object)1.15F, (Object) sum);
    }

}