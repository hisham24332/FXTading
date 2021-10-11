package com.assignment.fxtrading;

import java.util.ArrayList;

public class FXTradingApplication {
    private ArrayList<FXTrading> objTrade;

    public FXTradingApplication() {
        objTrade = new ArrayList<FXTrading>();
    }

    public boolean addNewRecord(FXTrading contact) {
        objTrade.add(contact);
        return true;
    }

    public void printContacts() {
        System.out.println("TradeNo\t CurrencyPair\tCustomerName\tAmount\tRate");
        for (int i = 0; i < objTrade.size(); i++) {
            System.out.println("  " + (i + 1) + ". \t   " + objTrade.get(i).getCurrencyPair() + " \t " + objTrade.get(i).getName() + " \t\t "+ objTrade.get(i).getAmount() + " \t "+ objTrade.get(i).getRate());
        }
    }
}