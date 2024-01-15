package org.example.inheritance.money;

import org.junit.Test;

public enum Coin implements Money {
    PENNY(0.01F),
    NICKEL(0.05F),
    DIME(0.10F),
    QUARTER(0.25F);

    public final Float value;

    private Coin(Float value) {
        this.value = value;
    }

    @Override
    public Float getValue() {
        return this.value;
    }


    public static void main(String[] args) {
        System.out.println(PENNY.getValue());
    }


    @Test
    public void testMain() {
        System.out.println(QUARTER.getValue());

    }
}
