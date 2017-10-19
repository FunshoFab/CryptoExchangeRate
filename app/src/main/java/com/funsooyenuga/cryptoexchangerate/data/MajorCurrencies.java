package com.funsooyenuga.cryptoexchangerate.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by FAB THE GREAT on 12/10/2017.
 */

public class MajorCurrencies {

    @SerializedName("NGN") private Currency ngn;
    @SerializedName("USD") private Currency usd;
    @SerializedName("EUR") private Currency eur;
    @SerializedName("GBP") private Currency gbp;
    @SerializedName("AUD") private Currency aud;
    @SerializedName("ZAR") private Currency zar;
    @SerializedName("CAD") private Currency cad;
    @SerializedName("JPY") private Currency jpy;
    @SerializedName("CNY") private Currency cny;
    @SerializedName("INR") private Currency inr;

    @SerializedName("CHF") private Currency chf;
    @SerializedName("GHS") private Currency ghs;
    @SerializedName("NZD") private Currency nzd;
    @SerializedName("KES") private Currency kes;
    @SerializedName("SGD") private Currency sgd;
    @SerializedName("TWD") private Currency twd;
    @SerializedName("RUB") private Currency rub;
    @SerializedName("MXN") private Currency mxn;
    @SerializedName("ILS") private Currency ils;
    @SerializedName("MYR") private Currency myr;

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
