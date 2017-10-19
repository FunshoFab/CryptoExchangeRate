package com.funsooyenuga.cryptoexchangerate.data;

import com.google.gson.annotations.SerializedName;

/**
 * A single Currency object would hold value from both ETH and BTC.
 * <p>
 * It would also have 2 sets of data: One from {@link ApiResponse.Raw} and one from {@link ApiResponse.Display}
 * <p>
 * The symbol variable holds an abbreviation of the currency in Raw and the actual currency symbol
 * in Display. Hence, we separate symbol from abbr in the class.
 */

public class Currency {

    // Read directly from the API
    @SerializedName("TOSYMBOL")
    private String symbol;

    @SerializedName("FROMSYMBOL")
    private String fromSymbol;

    @SerializedName("PRICE")
    private String price; // read price as String because Display price is a string

    // To be set manually
    private String abbr; // The "ToSymbol" in Raw is the abbr of the currency eg USD, NGN
    private String fullName;
    private float btcRawPrice; // The exchange rate
    private float ethRawPrice;
    private String btcDisplayPrice; // formatted price for display
    private String ethDisplayPrice;
    private String btcSymbol;
    private String ethSymbol;

    public Currency(String abbr,
                    String fullName,
                    String btcDisplayPrice,
                    float btcRawPrice,
                    String ethDisplayPrice,
                    float ethRawPrice,
                    String btcSymbol,
                    String ethSymbol) {
        this.abbr = abbr;
        this.btcDisplayPrice = btcDisplayPrice;
        this.btcRawPrice = btcRawPrice;
        this.ethDisplayPrice = ethDisplayPrice;
        this.ethRawPrice = ethRawPrice;
        this.fullName = fullName;
        this.btcSymbol = btcSymbol;
        this.ethSymbol = ethSymbol;
    }

    // Helper methods
    public String getEthSymbol() {
        return ethSymbol;
    }

    public String getBtcSymbol() {
        return btcSymbol;
    }

    public String getFromSymbol() {
        return fromSymbol;
    }

    public String getPrice() {
        return price;
    }

    public String getBtcDisplayPrice() {
        return btcDisplayPrice;
    }

    public float getBtcRawPrice() {
        return btcRawPrice;
    }

    public float getEthRawPrice() {
        return ethRawPrice;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getEthDisplayPrice() {
        return ethDisplayPrice;
    }

}
