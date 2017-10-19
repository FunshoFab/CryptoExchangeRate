package com.funsooyenuga.cryptoexchangerate.home;


import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.funsooyenuga.cryptoexchangerate.R;

public class AddCurrencyFragment extends DialogFragment {

    public static AddCurrencyFragment newInstance() {

        Bundle args = new Bundle();

        AddCurrencyFragment fragment = new AddCurrencyFragment();
        fragment.setArguments(args);

        return fragment;
    }

    public AddCurrencyFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_add_currency, null);
        Spinner spinner = (Spinner) v.findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.add_new_currency)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }

}
