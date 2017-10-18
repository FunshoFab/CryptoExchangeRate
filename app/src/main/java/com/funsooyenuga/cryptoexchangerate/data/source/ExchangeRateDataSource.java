package com.funsooyenuga.cryptoexchangerate.data.source;

import android.content.Context;

import com.funsooyenuga.cryptoexchangerate.data.ApiResponse;
import com.funsooyenuga.cryptoexchangerate.data.Currency;
import com.funsooyenuga.cryptoexchangerate.data.CurrencyNames;
import com.funsooyenuga.cryptoexchangerate.data.api.CryptoCompareService;
import com.funsooyenuga.cryptoexchangerate.util.ActivityUtils;
import com.funsooyenuga.cryptoexchangerate.util.ApiUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import static com.funsooyenuga.cryptoexchangerate.util.ExchangeRateUtils.addCurrenciesToMap;

/**
 * Created by FAB THE GREAT on 14/10/2017.
 *
 * Handles requests to the API
 */

public class ExchangeRateDataSource {

    private static ExchangeRateDataSource instance;

    private List<Currency> cachedDefaultCurrencies;
    private ApiResponse cachedApiResponse;

    private Map<String, Currency> rawBtcMap, rawEthMap;
    private Map<String, Currency> displayBtcMap, displayEthMap;

    private boolean mapInit = false;


    private ExchangeRateDataSource() {
        // Prevent direct instantiation as this class is a singleton
    }

    public static ExchangeRateDataSource getInstance() {
        if (instance == null) {
            instance = new ExchangeRateDataSource();
        }
        return instance;
    }

    /**
     * Returns a list of currencies that should be displayed on the home screen.
     * Each currency contains the latest exchange rate in both BTC and ETH
     *
     * @param refresh if true, Exchange rate would be reloaded from server even if a cached version
     *                is available
     * @return
     */
    public Observable<ApiResponse> getExchangeRate(final Context context, boolean refresh) {
        if (cacheUnavailable() || refresh) {
            return CryptoCompareService.createCryptoCompareService(context)
                    .getExchangeRate(ApiUtils.QUERY_FROM_SYMBOLS_VALUES, ApiUtils.QUERY_TO_SYMBOLS_VALUES)
                    .doOnNext(new Consumer<ApiResponse>() {
                        @Override
                        public void accept(ApiResponse apiResponse) throws Exception {
                            cachedApiResponse = apiResponse;
                        }
                    });
        } else {
            return Observable.just(cachedApiResponse);
        }
    }

    private boolean cacheUnavailable() {
        return cachedApiResponse == null;
    }

    /**
     * Generates a list of currencies from the ApiResponse and saves it in a cache
     *
     * @param response
     * @return
     */
    public List<Currency> parseApiResponse(ApiResponse response, String defaultCurrencies) {
        List<Currency> currencyList = new ArrayList<>();

        initMaps(response);
        String[] currencies = defaultCurrencies.split(",");

        for (String currency : currencies) {
            currencyList.add(createCurrency(currency));
        }

        cachedDefaultCurrencies = currencyList;
        return currencyList;
    }

    /**
     * Creates a new Currency object with all the necessary fields
     *
     * @param currencyAbbr the short name of the Currency to be created
     * @return
     */
    private Currency createCurrency(String currencyAbbr) {
        Currency displayBtc = displayBtcMap.get(currencyAbbr);
        Currency displayEth = displayEthMap.get(currencyAbbr);
        Currency rawBtc = rawBtcMap.get(currencyAbbr);
        Currency rawEth = rawEthMap.get(currencyAbbr);

        String abbr = rawBtc.getSymbol(); // Symbol in Raw is always the short name of the currency
        String fullName  = CurrencyNames.valueOf(abbr).getName();

        String btcDisplayPrice  = displayBtc.getPrice();
        float btcPrice = Float.valueOf(rawBtc.getPrice());
        String btcSymbol = displayBtc.getFromSymbol();

        String ethDisplayPrice = displayEth.getPrice();
        float ethPrice = Float.valueOf(rawEth.getPrice());
        String ethSymbol = displayEth.getFromSymbol();

        return new Currency(abbr, fullName, btcDisplayPrice, btcPrice,
                ethDisplayPrice, ethPrice, btcSymbol, ethSymbol);
    }

    public Currency getCurrency(String currencyName) {
        for (Currency c : cachedDefaultCurrencies) {
            if (c.getFullName().equals(currencyName))
                return c;
        }
        return null;
    }

    /**
     * Add a new Currency to the default currencies shown on the home screen
     *
     * @param currencyAbbr the abbr of the Currency to be added
     * @return
     */
    public void addNewDefaultCurrency(Context context, String currencyAbbr) {
        cachedDefaultCurrencies.add(createCurrency(currencyAbbr));
        ActivityUtils.addDefaultCurrency(context, currencyAbbr);
    }

    /**
     * Adds the values of the ApiResponse to maps for easy access
     *
     * @param response
     */
    private void initMaps(ApiResponse response) {
        if (!mapInit) {
            rawBtcMap = addCurrenciesToMap(response.getRaw().getBitcoin());
            rawEthMap = addCurrenciesToMap(response.getRaw().getEthereum());
            displayBtcMap = addCurrenciesToMap(response.getDisplay().getBitcoin());
            displayEthMap = addCurrenciesToMap(response.getDisplay().getEthereum());
            mapInit = true;
        }
    }


    public List<Currency> getCachedDefaultCurrencies() {
        return cachedDefaultCurrencies;
    }
}
