package com.funsooyenuga.cryptoexchangerate.util;

import com.funsooyenuga.cryptoexchangerate.data.Currency;
import com.funsooyenuga.cryptoexchangerate.data.MajorCurrencies;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FAB THE GREAT on 14/10/2017.
 */

public class ExchangeRateUtils {

    public static Map<String, Currency> addCurrenciesToMap(MajorCurrencies c) {
        Map<String, Currency> currencies = new HashMap<>();

        currencies.put("Nigerian Naira (NGN)", c.getNgn());
        currencies.put("US Dollars (USD)", c.getUsd());
        currencies.put("Euro (EUR)", c.getEur());
        currencies.put("Great Britain Pound (GBP)", c.getGbp());
        currencies.put("Australian Dollar (AUD)", c.getAud());
        currencies.put("South African Rand (ZAR)", c.getZar());
        currencies.put("Canada Dollar (CAD)", c.getCad());
        currencies.put("Japanese Yen (JPY)", c.getJpy());
        currencies.put("Chinese Yen (CNY)", c.getCny());
        currencies.put("India Rupee (INR)", c.getInr());

        currencies.put("Switzerland Franc (CHF)", c.getChf());
        currencies.put("Ghana New Cedi (GHS)", c.getGhs());
        currencies.put("New Zealand Dollar (NZD)", c.getNzd());
        currencies.put("Kenya Shilling (KES)", c.getKes());
        currencies.put("Singapore Dollar (SGD)", c.getSgd());
        currencies.put("Taiwan Dollar (TWD)", c.getTwd());
        currencies.put("Russian Rouble (RUB)", c.getRub());
        currencies.put("Mexican Peso (MXN)", c.getMxn());
        currencies.put("Israel New Shekel (ILS)", c.getIls());
        currencies.put("Malaysia Ringgit (MYR)", c.getMyr());

        return currencies;
    }
}
