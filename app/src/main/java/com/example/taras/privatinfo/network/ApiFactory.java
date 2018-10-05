package com.example.taras.privatinfo.network;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.taras.privatinfo.App;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

class ApiFactory {

    private static final String API_ENDPOINT = "https://api.privatbank.ua/p24api/";

    private static OkHttpClient sClient;
    private static RetrofitService sService;

    public static RetrofitService getRetrofitService() {
        //I know that double checked locking is not a good pattern, but it's enough here
        RetrofitService service = sService;
        if (service == null) {
            synchronized (ApiFactory.class) {
                service = sService;
                if (service == null) {
                    service = sService = createService();
                }
            }
        }
        return service;
    }

    private static RetrofitService createService() {
        return new Retrofit.Builder()
                .baseUrl(API_ENDPOINT)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(RetrofitService.class);
    }

    @NonNull
    public static OkHttpClient getClient() {
        OkHttpClient client = sClient;
        if (client == null) {
            synchronized (ApiFactory.class) {
                client = sClient;
                if (client == null) {
                    client = sClient = buildClient();
                }
            }
        }
        return client;
    }

    @NonNull
    private static OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new Interceptors.OfflineCacheInterceptor())
                .addNetworkInterceptor(new Interceptors.NetworkCacheInterceptor())
                .cache(Interceptors.provideCache())
                .addInterceptor(LoggingInterceptor.create())
                .build();
    }

}
