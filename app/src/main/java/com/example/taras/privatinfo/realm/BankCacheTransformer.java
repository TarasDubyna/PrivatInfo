package com.example.taras.privatinfo.realm;

import android.util.Log;

import com.example.taras.privatinfo.realm.model.BankDB;
import com.example.taras.privatinfo.realm.model.DeviceDB;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;
import rx.functions.Func1;

public class BankCacheTransformer implements Observable.Transformer<List<BankDB>, List<BankDB>> {
    private final String LOG_TAG = "myLogs";

    private final Func1<List<BankDB>, Observable<List<BankDB>>> mSaveFunc = banks -> {
        Realm.getDefaultInstance().executeTransaction(realm -> {
            realm.delete(BankDB.class);
            realm.insert(banks);
            Log.d(LOG_TAG, getClass().getName() + " -> mSaveFunc");
        });
        return Observable.just(banks);
    };

    private final Func1<Throwable, Observable<List<BankDB>>> mCacheErrorHandler = throwable -> {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<BankDB> results = realm.where(BankDB.class).findAll();
        Log.d(LOG_TAG, getClass().getName() + " -> mCacheErrorHandler -> throwable = " + throwable.toString());
        return Observable.just(realm.copyFromRealm(results));
    };

    @Override
    public Observable<List<BankDB>> call(Observable<List<BankDB>> postsObservable) {
        Log.d(LOG_TAG, getClass().getName() + " -> call()");
        return postsObservable
                .flatMap(mSaveFunc)
                .onErrorResumeNext(mCacheErrorHandler);
    }
}
