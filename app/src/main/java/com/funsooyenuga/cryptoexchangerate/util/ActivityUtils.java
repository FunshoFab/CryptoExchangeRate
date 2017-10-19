package com.funsooyenuga.cryptoexchangerate.util;

import android.content.Context;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by FAB THE GREAT on 15/10/2017.
 */

public class ActivityUtils {

    private static final String PREF_DEFAULT_CURRENCIES = "defaultCurrencies";

    private static final String DEFAULT_CURRENCIES = "Nigerian Naira (NGN)," +
            "US Dollars (USD)," +
            "Euro (EUR)";

    /**
     * Add a fragment to an activity
     *
     * @param fm support fragment manager (getSupportFragmentManager() is fine)
     * @param resourceId the id of the layout where the fragment should be
     * @param fragment an instance of the fragment to be added
     * @param tag optional tag to find the fragment
     */
    public static void hostFragment(FragmentManager fm, int resourceId, Fragment fragment, String tag) {
        if (fragment != null) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(resourceId, fragment, tag)
                    .commit();
        }
    }

    /**
     * Returns the list of default currencies to be displayed on the Home Screen
     *
     * @param context
     * @return
     */
    public static String getDefaultCurrencies(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(PREF_DEFAULT_CURRENCIES, DEFAULT_CURRENCIES);
    }

    /**
     * Add a new Currency to the currencies displayed in the Home Screen
     *
     * @param context
     * @param currencyName the abbreviation of the currency
     */
    public static void addDefaultCurrency(Context context, String currencyName) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(PREF_DEFAULT_CURRENCIES, getDefaultCurrencies(context) + "," + currencyName)
                .apply();
    }
}
