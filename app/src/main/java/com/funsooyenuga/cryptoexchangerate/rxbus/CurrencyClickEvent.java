package com.funsooyenuga.cryptoexchangerate.rxbus;

/**
 * Created by FAB THE GREAT on 19/10/2017.
 */

public class CurrencyClickEvent {

    private String currencyName;

    public CurrencyClickEvent(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyName() {
        return currencyName;
    }
}
