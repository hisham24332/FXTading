package com.assignment.fxtrading;

public class FXTrading {
    private String name;
    private String currencyPair;
    private int amountToTransfer;
    private String rate;

    public FXTrading(String name, String currencyPair, int amountToTransfer, String rate) {
        this.name = name;
        this.currencyPair = currencyPair;
        this.amountToTransfer = amountToTransfer;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public String getCurrencyPair() {
        return currencyPair;
    }

    public int getAmount() {
        return amountToTransfer;
    }

    public String getRate() {
        return rate;
    }

    public static FXTrading createRecord(String name, String currencyPair, int amountToTransfer, String rate) {
        return new FXTrading(name, currencyPair, amountToTransfer, rate);
    }
}