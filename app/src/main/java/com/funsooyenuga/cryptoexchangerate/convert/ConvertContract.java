package com.funsooyenuga.cryptoexchangerate.convert;

import android.text.TextWatcher;

import com.funsooyenuga.cryptoexchangerate.data.Currency;

/**
 * Created by FAB THE GREAT on 18/10/2017.
 */

interface ConvertContract {

    interface View {

        void updateConvertedPrice(String btc, String eth);

        void toggleVisibility(Boolean flag);
    }

    interface Presenter {

        Currency getCurrency(String currencyName);

        void subscribe(ConvertContract.View view, String currencyName);

        TextWatcher provideTextWatcher();

        String provideBtcSymbol();

        String provideEthSymbol();

    }
}
