package com.funsooyenuga.cryptoexchangerate.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.funsooyenuga.cryptoexchangerate.R;
import com.funsooyenuga.cryptoexchangerate.data.Currency;

import java.util.ArrayList;
import java.util.List;

public class ExchangeRateFragment extends Fragment implements ExchangeRateContract.View {

    private ExchangeRateContract.Presenter presenter;
    private RecyclerAdapter adapter;

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
        adapter = new RecyclerAdapter(getActivity(), new ArrayList<Currency>(),
                new RecyclerAdapter.CurrencyClickListener() {
                    @Override
                    public void onCurrencyClick(Currency currency) {
                        // do something
                    }
                });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_exchange_rate, container, false);

        RecyclerView exchangeRateRv = (RecyclerView) v.findViewById(R.id.exchange_rate_rv);
        exchangeRateRv.setAdapter(adapter);
        exchangeRateRv.setLayoutManager(new LinearLayoutManager(getActivity()));

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
        adapter.refresh(currencies);
    }
}
