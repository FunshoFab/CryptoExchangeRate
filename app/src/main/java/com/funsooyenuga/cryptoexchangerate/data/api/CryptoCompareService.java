package com.funsooyenuga.cryptoexchangerate.data.api;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.funsooyenuga.cryptoexchangerate.util.ApiUtils.BASE_URL;

/**
 * Created by FAB THE GREAT on 13/10/2017.
 */

public class CryptoCompareService {

    public static CryptoCompareApi createCryptoCompareService(Context context) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.interceptors().add(new MockInterceptor(context));

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient.build())
                .build();

        return retrofit.create(CryptoCompareApi.class);
    }
}
