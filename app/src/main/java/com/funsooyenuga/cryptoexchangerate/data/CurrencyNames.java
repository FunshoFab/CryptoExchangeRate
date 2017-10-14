package com.funsooyenuga.cryptoexchangerate.data;

/**
 * Created by FAB THE GREAT on 13/10/2017.
 */
public enum CurrencyNames {

    NGN("Nigerian Naira"),
    USD("US Dollars"),
    EUR("Euro"),
    GBP("Great Britain Pound"),
    AUD("Australian Dollar"),
    ZAR("South African Rand"),
    CAD("Canada Dollar"),
    JPY("Japanese Yen"),
    CNY("Chinese Yen"),
    INR("India Rupee "),
    CHF("Switzerland Franc"),
    GHS("Ghana New Cedi"),
    NZD("New Zealand Dollar"),
    KES("Kenya Shilling"),
    SGD("Singapore Dollar"),
    TWD("Taiwan Dollar"),
    RUB("Russian Rouble"),
    MXN("Mexican Peso"),
    ILS("Israel New Shekel"),
    MYR("Malaysia Ringgit");

    private String name;

    CurrencyNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

