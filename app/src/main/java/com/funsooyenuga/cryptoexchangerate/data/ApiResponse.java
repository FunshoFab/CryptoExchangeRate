package com.funsooyenuga.cryptoexchangerate.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by FAB THE GREAT on 12/10/2017.
 */

public class ApiResponse {

    @SerializedName("RAW") private Raw raw;

    @SerializedName("DISPLAY") private Display display;

    public Display getDisplay() {
        return display;
    }

    public Raw getRaw() {
        return raw;
    }


    public class Raw extends CryptoCurrency{

    }

    public class Display extends CryptoCurrency {

    }

    private class CryptoCurrency {
        @SerializedName("BTC") Bitcoin bitcoin;
        @SerializedName("ETH") Ethereum ethereum;

        public Bitcoin getBitcoin() {
            return bitcoin;
        }

        public Ethereum getEthereum() {
            return ethereum;
        }
    }

    public class Bitcoin extends MajorCurrencies {

    }

    public class Ethereum extends MajorCurrencies {

    }
}
