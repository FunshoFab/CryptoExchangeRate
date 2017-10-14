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

        currencies.put("NGN", c.getNgn());
        currencies.put("USD", c.getUsd());
        currencies.put("EUR", c.getEur());
        currencies.put("GBP", c.getGbp());
        currencies.put("AUD", c.getAud());
        currencies.put("ZAR", c.getZar());
        currencies.put("CAD", c.getCad());
        currencies.put("JPY", c.getJpy());
        currencies.put("CNY", c.getCny());
        currencies.put("INR", c.getInr());

        currencies.put("CHF", c.getChf());
        currencies.put("GHS", c.getGhs());
        currencies.put("NZD", c.getNzd());
        currencies.put("KES", c.getKes());
        currencies.put("SGD", c.getSgd());
        currencies.put("TWD", c.getTwd());
        currencies.put("RUB", c.getRub());
        currencies.put("MXN", c.getMxn());
        currencies.put("ILS", c.getIls());
        currencies.put("MYR", c.getMyr());

        return currencies;
    }
}
