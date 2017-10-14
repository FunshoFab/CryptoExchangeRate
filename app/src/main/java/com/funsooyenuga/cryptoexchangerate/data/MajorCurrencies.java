package com.funsooyenuga.cryptoexchangerate.data;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FAB THE GREAT on 12/10/2017.
 */

public class MajorCurrencies {

    @SerializedName("NGN") protected Currency ngn;
    @SerializedName("USD") protected Currency usd;
    @SerializedName("EUR") protected Currency eur;
    @SerializedName("GBP") protected Currency gbp;
    @SerializedName("AUD") protected Currency aud;
    @SerializedName("ZAR") protected Currency zar;
    @SerializedName("CAD") protected Currency cad;
    @SerializedName("JPY") protected Currency jpy;
    @SerializedName("CNY") protected Currency cny;
    @SerializedName("INR") protected Currency inr;

    @SerializedName("CHF") protected Currency chf;
    @SerializedName("GHS") protected Currency ghs;
    @SerializedName("NZD") protected Currency nzd;
    @SerializedName("KES") protected Currency kes;
    @SerializedName("SGD") protected Currency sgd;
    @SerializedName("TWD") protected Currency twd;
    @SerializedName("RUB") protected Currency rub;
    @SerializedName("MXN") protected Currency mxn;
    @SerializedName("ILS") protected Currency ils;
    @SerializedName("MYR") protected Currency myr;

    private Map<String, Currency> currencies = new HashMap<>();

    public Map<String, Currency> getAllCurrencies() {
        if (currencies.isEmpty()) {
            addCurrenciesToMap();
        }
        return currencies;
    }

    private void addCurrenciesToMap() {
        currencies.put("NGN", ngn);
        currencies.put("USD", usd);
        currencies.put("EUR", eur);
        currencies.put("GBP", gbp);
        currencies.put("AUD", aud);
        currencies.put("ZAR", zar);
        currencies.put("CAD", cad);
        currencies.put("JPY", jpy);
        currencies.put("CNY", cny);
        currencies.put("INR", inr);

        currencies.put("CHF", chf);
        currencies.put("GHS", ghs);
        currencies.put("NZD", nzd);
        currencies.put("KES", kes);
        currencies.put("SGD", sgd);
        currencies.put("TWD", twd);
        currencies.put("RUB", rub);
        currencies.put("MXN", mxn);
        currencies.put("ILS", ils);
        currencies.put("MYR", myr);
    }

    // Helper methods
    public Currency getAud() {
        return aud;
    }

    public Currency getCad() {
        return cad;
    }

    public Currency getChf() {
        return chf;
    }

    public Currency getCny() {
        return cny;
    }

    public Currency getEur() {
        return eur;
    }

    public Currency getGbp() {
        return gbp;
    }

    public Currency getGhs() {
        return ghs;
    }

    public Currency getIls() {
        return ils;
    }

    public Currency getInr() {
        return inr;
    }

    public Currency getJpy() {
        return jpy;
    }

    public Currency getKes() {
        return kes;
    }

    public Currency getMxn() {
        return mxn;
    }

    public Currency getMyr() {
        return myr;
    }

    public Currency getNgn() {
        return ngn;
    }

    public Currency getNzd() {
        return nzd;
    }

    public Currency getRub() {
        return rub;
    }

    public Currency getSgd() {
        return sgd;
    }

    public Currency getTwd() {
        return twd;
    }

    public Currency getUsd() {
        return usd;
    }

    public Currency getZar() {
        return zar;
    }
}
