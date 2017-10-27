package com.funsooyenuga.cryptoexchangerate.home;

import android.content.Context;
import android.support.design.widget.Snackbar;

import com.funsooyenuga.cryptoexchangerate.R;
import com.funsooyenuga.cryptoexchangerate.data.ApiResponse;
import com.funsooyenuga.cryptoexchangerate.data.source.ExchangeRateDataSource;
import com.funsooyenuga.cryptoexchangerate.rxbus.CurrencyChangeEvent;
import com.funsooyenuga.cryptoexchangerate.rxbus.RxBus;
import com.funsooyenuga.cryptoexchangerate.util.ActivityUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
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
        subscribeToRxBus();
        getExchangeRate(false);
    }

    private void subscribeToRxBus() {
        compositeDisposable.add(
                RxBus.getInstance().subscribeToBus().subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        if (o instanceof CurrencyChangeEvent) {
                            view.showExchangeRate(dataSource.getDefaultCurrencies());
                        }
                    }
                }));
    }

    private void getExchangeRate(final boolean refresh) {
        compositeDisposable.add(
                dataSource.getExchangeRate(context, refresh)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<ApiResponse>() {
                            @Override
                            public void onNext(ApiResponse value) {
                                view.showExchangeRate(dataSource.parseApiResponse(value,
                                        ActivityUtils.getDefaultCurrencies(context)));
                                if (refresh) {
                                    view.showSnack(context.getString(R.string.refresh_complete),
                                            Snackbar.LENGTH_SHORT, null, null);
                                }
                            }

                            @Override
                            public void onComplete() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                view.errorWhileLoading();
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
