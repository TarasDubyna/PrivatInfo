package com.example.taras.privatinfo.realm;

import android.util.Log;

import com.example.taras.privatinfo.realm.model.DeviceDB;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import rx.Observable;
import rx.functions.Func1;

public class TerminalCacheTransformer implements Observable.Transformer<List<DeviceDB>, List<DeviceDB>> {
    private final String LOG_TAG = "myLogs";

    private final Func1<List<DeviceDB>, Observable<List<DeviceDB>>> mSaveFunc = devices -> {
        Realm.getDefaultInstance().executeTransaction(realm -> {
            RealmResults<DeviceDB> realmResults = realm.where(DeviceDB.class).equalTo("type", "TSO").findAll();
            realmResults.deleteAllFromRealm();
            realm.insert(devices);
            Log.d(LOG_TAG, getClass().getName() + " -> mSaveFunc");
        });
        return Observable.just(devices);
    };

    private final Func1<Throwable, Observable<List<DeviceDB>>> mCacheErrorHandler = throwable -> {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<DeviceDB> results = realm.where(DeviceDB.class).equalTo("type", "TSO").findAll();
        Log.d(LOG_TAG, getClass().getName() + " -> mCacheErrorHandler -> throwable = " + throwable.toString());
        return Observable.just(realm.copyFromRealm(results));
    };

    @Override
    public Observable<List<DeviceDB>> call(Observable<List<DeviceDB>> devicesObservable) {
        Log.d(LOG_TAG, getClass().getName() + " -> call()");
        return devicesObservable
                .flatMap(mSaveFunc)
                .onErrorResumeNext(mCacheErrorHandler);
    }
}
