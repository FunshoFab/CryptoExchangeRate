package com.funsooyenuga.cryptoexchangerate.convert;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.funsooyenuga.cryptoexchangerate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConvertFragment extends Fragment implements ConvertContract.View {

    public static final String ARGS_CURRENCY_ABBR = "currencyAbbr";

    private String currencyName;
    private ConvertContract.Presenter presenter;

    private EditText amount;
    private TextView btcSymbol, btcConvertedPrice, ethSymbol, ethConvertedPrice;
    private RelativeLayout displayConversion;

    public static ConvertFragment newInstance(String currencyAbbr) {
        Bundle args = new Bundle();
        args.putString(ARGS_CURRENCY_ABBR, currencyAbbr);

        ConvertFragment frag = new ConvertFragment();
        frag.setArguments(args);

        return frag;
    }


    public ConvertFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currencyName = getArguments().getString(ARGS_CURRENCY_ABBR);

        presenter = new ConvertPresenter();
        presenter.subscribe(this, currencyName);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_convert, container, false);

        displayConversion = (RelativeLayout) v.findViewById(R.id.display_conversion);
        displayConversion.setVisibility(View.GONE);

        amount = (EditText) v.findViewById(R.id.amount);
        amount.addTextChangedListener(presenter.provideTextWatcher());

        btcConvertedPrice  = (TextView) v.findViewById(R.id.btc_converted_price);
        btcSymbol = (TextView) v.findViewById(R.id.btc_symbol);
        btcSymbol.setText(presenter.provideBtcSymbol());

        ethConvertedPrice  = (TextView) v.findViewById(R.id.eth_converted_price);
        ethSymbol = (TextView) v.findViewById(R.id.eth_symbol);
        ethSymbol.setText(presenter.provideEthSymbol());

        return v;
    }

    @Override
    public void toggleVisibility(Boolean flag) {
        if (displayConversion.getVisibility() == View.GONE && flag)
            displayConversion.setVisibility(View.VISIBLE);
        else if (!flag)
            displayConversion.setVisibility(View.GONE);
    }

    @Override
    public void updateConvertedPrice(String btc, String eth) {
        displayConversion.setVisibility(View.VISIBLE);
        btcConvertedPrice.setText(btc);
        ethConvertedPrice.setText(eth);
    }
}
