package com.example.taras.privatinfo;

import android.app.Application;
import android.content.Context;

import com.example.taras.privatinfo.utils.Constants;
import com.orhanobut.hawk.Hawk;

import java.io.File;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.rx.RealmObservableFactory;

public class App extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();

        Hawk.init(this)
                .build();

        //Data Base
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .rxFactory(new RealmObservableFactory())
                .schemaVersion(Constants.REALM_DB_VERSION)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);
    }

    public static Context getAppContext(){
        return sContext;
    }

}
