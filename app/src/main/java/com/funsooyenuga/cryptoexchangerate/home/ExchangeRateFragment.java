package com.funsooyenuga.cryptoexchangerate.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.funsooyenuga.cryptoexchangerate.R;
import com.funsooyenuga.cryptoexchangerate.data.Currency;

import java.util.List;

public class ExchangeRateFragment extends Fragment implements ExchangeRateContract.View {

    private ExchangeRateContract.Presenter presenter;

    public ExchangeRateFragment() {
        // Required empty public constructor
    }

    public static ExchangeRateFragment newInstance() {
        return new ExchangeRateFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ExchangeRatePresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_exchange_rate, container, false);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe(this, getActivity());
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }

    @Override
    public void showExchangeRate(List<Currency> currencies) {
        for (Currency c : currencies) {
            Log.d("Exchange", c.getFullName() + " - " +  c.getBtcDisplayPrice() + " - " + c.getBtcRawPrice());
            Log.d("Exchange", c.getFullName() + " - " +  c.getEthDisplayPrice() + " - " + c.getEthRawPrice());
        }
    }
}
