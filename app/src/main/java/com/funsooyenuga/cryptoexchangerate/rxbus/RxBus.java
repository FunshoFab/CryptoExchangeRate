package com.funsooyenuga.cryptoexchangerate.rxbus;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by FAB THE GREAT on 19/10/2017.
 */

public class RxBus {

    private static RxBus instance;
    private PublishSubject<Object> subject = PublishSubject.create();

    private RxBus() {}

    public static RxBus getInstance() {
        if (instance == null)
            instance = new RxBus();
        return instance;
    }

    public void sendEvent(Object object) {
        subject.onNext(object);
    }

    public Observable<Object> subscribeToBus() {
        return subject;
    }
}
