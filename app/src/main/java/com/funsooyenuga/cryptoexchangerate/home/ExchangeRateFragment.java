package com.funsooyenuga.cryptoexchangerate.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.funsooyenuga.cryptoexchangerate.R;
import com.funsooyenuga.cryptoexchangerate.data.Currency;

import java.util.ArrayList;
import java.util.List;

public class ExchangeRateFragment extends Fragment implements ExchangeRateContract.View {

    private ExchangeRateContract.Presenter presenter;
    private RecyclerAdapter adapter;
    private SwipeRefreshLayout swipeRefresh;
    private TextView errorWhileLoading;

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

        errorWhileLoading = (TextView) v.findViewById(R.id.error_while_loading);
        RecyclerView exchangeRateRv = (RecyclerView) v.findViewById(R.id.exchange_rate_rv);
        exchangeRateRv.setAdapter(adapter);
        exchangeRateRv.setLayoutManager(new LinearLayoutManager(getActivity()));

        swipeRefresh = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeColors(ContextCompat.getColor(getActivity(), R.color.colorAccent),
                ContextCompat.getColor(getActivity(), R.color.colorPrimary),
                ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark));

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.refreshExchangeRate();
            }
        });

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        swipeRefresh.setRefreshing(true);
        presenter.subscribe(this, getActivity());
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }

    @Override
    public void showExchangeRate(List<Currency> currencies) {
        swipeRefresh.setRefreshing(false);
        errorWhileLoading.setVisibility(View.GONE);
        adapter.refresh(currencies);
    }

    @Override
    public void showSnack(String message, int length, String actionText, View.OnClickListener listener) {
        Snackbar.make(getView(), message, length)
                .setAction(actionText, listener)
                .show();

    }

    @Override
    public void errorWhileLoading() {
        swipeRefresh.setRefreshing(false);
        errorWhileLoading.setVisibility(View.VISIBLE);
    }
}
