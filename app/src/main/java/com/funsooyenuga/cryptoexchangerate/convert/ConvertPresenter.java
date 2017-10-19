package com.funsooyenuga.cryptoexchangerate.convert;

import android.text.Editable;
import android.text.TextWatcher;

import com.funsooyenuga.cryptoexchangerate.data.Currency;
import com.funsooyenuga.cryptoexchangerate.data.source.ExchangeRateDataSource;

import java.text.DecimalFormat;

/**
 * Created by FAB THE GREAT on 19/10/2017.
 */

public class ConvertPresenter implements ConvertContract.Presenter {

    private ConvertContract.View view;
    private Currency currency;
    private float btcPrice, ethPrice;
    private DecimalFormat decimalFormat = new DecimalFormat("#.####");

    @Override
    public Currency getCurrency(String currencyName) {
        return ExchangeRateDataSource.getInstance().getCurrency(currencyName);
    }

    @Override
    public void subscribe(ConvertContract.View view, String currencyName) {
        this.view = view;
        currency = ExchangeRateDataSource.getInstance().getCurrency(currencyName);
        btcPrice = currency.getBtcRawPrice();
        ethPrice = currency.getEthRawPrice();
    }

    @Override
    public TextWatcher provideTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() <= 0) {
                    view.toggleVisibility(false);
                } else {
                    view.toggleVisibility(true);
                    float btc = Float.valueOf(s.toString()) / btcPrice;
                    float eth = Float.valueOf(s.toString()) / ethPrice;
                    view.updateConvertedPrice(decimalFormat.format(btc), decimalFormat.format(eth));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    @Override
    public String provideBtcSymbol() {
        return currency.getBtcSymbol();
    }

    @Override
    public String provideEthSymbol() {
        return currency.getEthSymbol();
    }
}
