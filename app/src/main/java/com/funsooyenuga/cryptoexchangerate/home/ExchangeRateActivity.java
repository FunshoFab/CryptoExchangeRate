package com.funsooyenuga.cryptoexchangerate.home;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.funsooyenuga.cryptoexchangerate.R;
import com.funsooyenuga.cryptoexchangerate.convert.ConvertActivity;
import com.funsooyenuga.cryptoexchangerate.convert.ConvertFragment;
import com.funsooyenuga.cryptoexchangerate.rxbus.CurrencyClickEvent;
import com.funsooyenuga.cryptoexchangerate.rxbus.RxBus;
import com.funsooyenuga.cryptoexchangerate.util.ActivityUtils;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class ExchangeRateActivity extends AppCompatActivity {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_rate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActivityUtils.hostFragment(getSupportFragmentManager(), R.id.content_frame,
                ExchangeRateFragment.newInstance(), null);

        FloatingActionButton addCurrency = (FloatingActionButton) findViewById(R.id.add_currency);
        addCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddCurrencyScreen();
            }
        });

        subscribeToBus();
    }

    private void subscribeToBus() {
        compositeDisposable.add(
                RxBus.getInstance().subscribeToBus().subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        if (o instanceof CurrencyClickEvent) {
                            CurrencyClickEvent event = (CurrencyClickEvent) o;
                            showConvertScreen(event.getCurrencyName());
                        }
                    }
                }));
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    private void showAddCurrencyScreen() {
        AddCurrencyFragment frag = AddCurrencyFragment.newInstance();
        frag.show(getSupportFragmentManager(), null);
    }

    private void showConvertScreen(String currencyName) {
        boolean isTwoPane = findViewById(R.id.convert_container) != null;

        if (isTwoPane) {
            ActivityUtils.hostFragment(getSupportFragmentManager(), R.id.convert_container,
                    ConvertFragment.newInstance(currencyName), null);
        } else {
            startActivity(ConvertActivity.newIntent(this, currencyName));
        }
    }
}
