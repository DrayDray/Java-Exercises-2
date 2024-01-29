package org.example.design.vendingmachine.data.exception;

public class SoldOutException extends Exception {
    private String message;

    public SoldOutException(String string) {
        this.message = string;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
