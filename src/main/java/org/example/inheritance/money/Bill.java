package org.example.inheritance.money;

public enum Bill implements Money{
    DOLLAR(1.0F),
    TWO_DOLLAR(2.0F);

    public final Float value;

    private Bill(Float value){
        this.value = value;
    }

    @Override
    public Float getValue() {
        return this.value;
    }
}
