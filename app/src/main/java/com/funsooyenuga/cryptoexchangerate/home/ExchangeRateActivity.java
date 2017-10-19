package com.funsooyenuga.cryptoexchangerate.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.funsooyenuga.cryptoexchangerate.R;
import com.funsooyenuga.cryptoexchangerate.convert.ConvertActivity;
import com.funsooyenuga.cryptoexchangerate.rxbus.CurrencyClickEvent;
import com.funsooyenuga.cryptoexchangerate.rxbus.RxBus;
import com.funsooyenuga.cryptoexchangerate.util.ActivityUtils;

import io.reactivex.functions.Consumer;

public class ExchangeRateActivity extends AppCompatActivity {

    private static final String TAG = ExchangeRateActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_rate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActivityUtils.hostFragment(getSupportFragmentManager(), R.id.content_frame,
                ExchangeRateFragment.newInstance(), null);

        RxBus.getInstance().subscribeToBus().subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                if (o instanceof CurrencyClickEvent) {
                    CurrencyClickEvent event = (CurrencyClickEvent) o;
                    showConvertScreen(event.getCurrencyName());
                }
            }
        });
    }

    private void showConvertScreen(String currencyName) {
        startActivity(ConvertActivity.newIntent(this, currencyName));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
