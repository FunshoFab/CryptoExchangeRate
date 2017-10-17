package com.funsooyenuga.cryptoexchangerate.data;

/**
 * Created by FAB THE GREAT on 13/10/2017.
 */
public enum CurrencyNames {

    NGN("Nigerian Naira (NGN)"),
    USD("US Dollars (USD)"),
    EUR("Euro (EUR)"),
    GBP("Great Britain Pound (GBP)"),
    AUD("Australian Dollar (AUD)"),
    ZAR("South African Rand (ZAR)"),
    CAD("Canada Dollar (CAD)"),
    JPY("Japanese Yen (JPY)"),
    CNY("Chinese Yen (CNY)"),
    INR("India Rupee (INR)"),
    CHF("Switzerland Franc (CHF)"),
    GHS("Ghana New Cedi (GHS)"),
    NZD("New Zealand Dollar"),
    KES("Kenya Shilling (KES)"),
    SGD("Singapore Dollar (SGD)"),
    TWD("Taiwan Dollar (TWD)"),
    RUB("Russian Rouble (RUB)"),
    MXN("Mexican Peso (MXN)"),
    ILS("Israel New Shekel (ILS)"),
    MYR("Malaysia Ringgit (MYR)");

    private String name;

    CurrencyNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

