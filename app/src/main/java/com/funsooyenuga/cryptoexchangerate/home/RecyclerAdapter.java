package com.funsooyenuga.cryptoexchangerate.home;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.funsooyenuga.cryptoexchangerate.R;
import com.funsooyenuga.cryptoexchangerate.data.Currency;

import java.util.List;

/**
 * Created by FAB THE GREAT on 16/10/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CurrencyHolder> {

    private List<Currency> currencies;
    private CurrencyClickListener listener;
    private Typeface openSans_Regular;
    private Typeface arial_Regular;
    private Typeface openSans_Semibold;

    public RecyclerAdapter(Context context, List<Currency> currencies, CurrencyClickListener listener) {
        this.currencies = currencies;
        this.listener = listener;

        openSans_Regular = Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Regular.ttf");
        arial_Regular = Typeface.createFromAsset(context.getAssets(), "fonts/arial.ttf");
        openSans_Semibold = Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Semibold.ttf");
    }

    @Override
    public CurrencyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.currency_card, parent, false);
        return new CurrencyHolder(v);
    }

    @Override
    public void onBindViewHolder(CurrencyHolder holder, int position) {
        Currency c = currencies.get(position);
        holder.currencyName.setText(c.getFullName());
        holder.btcSymbol.setText(c.getBtcSymbol());
        holder.btcPrice.setText(c.getBtcDisplayPrice());
        holder.ethSymbol.setText(c.getEthSymbol());
        holder.ethPrice.setText(c.getEthDisplayPrice());
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    class CurrencyHolder extends RecyclerView.ViewHolder {

        private TextView currencyName, btcSymbol, btcPrice, ethSymbol, ethPrice;

        CurrencyHolder(View itemView) {
            super(itemView);

            currencyName = (TextView) itemView.findViewById(R.id.currency_name);
            btcSymbol = (TextView) itemView.findViewById(R.id.btc_symbol);
            btcPrice = (TextView) itemView.findViewById(R.id.btc_price);
            ethSymbol= (TextView) itemView.findViewById(R.id.eth_symbol);
            ethPrice = (TextView) itemView.findViewById(R.id.eth_price);

            // Set typeface
            currencyName.setTypeface(openSans_Semibold);
            btcPrice.setTypeface(openSans_Regular);
            ethPrice.setTypeface(openSans_Regular);
            // Arial is used because is supports the bitcoin symbol
            btcSymbol.setTypeface(arial_Regular);
            ethSymbol.setTypeface(arial_Regular);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onCurrencyClick(currencies.get(getAdapterPosition()));
                }
            });
        }
    }

    public void refresh(List<Currency> currencies) {
        this.currencies = currencies;
        notifyDataSetChanged();
    }

    interface CurrencyClickListener {

        void onCurrencyClick(Currency currency);
    }
}
