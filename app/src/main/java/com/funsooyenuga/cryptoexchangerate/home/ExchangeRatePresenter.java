package com.funsooyenuga.cryptoexchangerate.home;

import android.content.Context;
import android.util.Log;

import com.funsooyenuga.cryptoexchangerate.data.ApiResponse;
import com.funsooyenuga.cryptoexchangerate.data.source.ExchangeRateDataSource;
import com.funsooyenuga.cryptoexchangerate.util.ActivityUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by FAB THE GREAT on 14/10/2017.
 */

public class ExchangeRatePresenter implements ExchangeRateContract.Presenter {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private Context context;
    private ExchangeRateContract.View view;
    private ExchangeRateDataSource dataSource;

    @Override
    public void subscribe(ExchangeRateContract.View view, Context context) {
        this.view = view;
        this.context = context;
        dataSource = ExchangeRateDataSource.getInstance();
        getExchangeRate(false);
    }

    private void getExchangeRate(boolean refresh) {
        compositeDisposable.add(
                dataSource.getExchangeRate(context, refresh)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<ApiResponse>() {
                            @Override
                            public void onNext(ApiResponse value) {
                                view.showExchangeRate(dataSource.parseApiResponse(value,
                                        ActivityUtils.getDefaultCurrencies(context)));
                            }

                            @Override
                            public void onComplete() {
                                Log.d("Exchange", "onComplete");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d("Exchange", e.toString());
                            }
                        })
        );
    }

    @Override
    public void refreshExchangeRate() {
        getExchangeRate(true);
    }

    @Override
    public void unsubscribe() {
        compositeDisposable.clear();
    }
}
