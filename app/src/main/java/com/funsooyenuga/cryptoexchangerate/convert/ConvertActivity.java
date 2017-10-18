package com.funsooyenuga.cryptoexchangerate.convert;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.funsooyenuga.cryptoexchangerate.R;
import com.funsooyenuga.cryptoexchangerate.util.ActivityUtils;

public class ConvertActivity extends AppCompatActivity {

    private static final String EXTRA_CURRENCY_NAME = "currencyName";

    public static Intent newIntent(Context context, String currencyName) {
        Intent intent = new Intent(context, ConvertActivity.class);
        intent.putExtra(EXTRA_CURRENCY_NAME, currencyName);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        String currencyName = getIntent().getStringExtra(EXTRA_CURRENCY_NAME);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setTitle(currencyName);

        ActivityUtils.hostFragment(getSupportFragmentManager(), R.id.content_frame,
                ConvertFragment.newInstance(currencyName), null);
    }

}
