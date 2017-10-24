package com.funsooyenuga.cryptoexchangerate.home;

import android.content.Context;

import com.funsooyenuga.cryptoexchangerate.data.Currency;

import java.util.List;

import static android.view.View.OnClickListener;

/**
 * Created by FAB THE GREAT on 14/10/2017.
 */

interface ExchangeRateContract {

    interface View {

        void showExchangeRate(List<Currency> currencies);

        void errorWhileLoading();

        void showSnack(String message, int length, String actionText, OnClickListener listener);
    }

    interface Presenter {

        void subscribe(ExchangeRateContract.View view, Context context);

        void refreshExchangeRate();

        void unsubscribe();
    }
}
