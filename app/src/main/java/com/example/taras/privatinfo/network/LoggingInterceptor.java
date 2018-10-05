package com.example.taras.privatinfo.network;

import android.support.annotation.NonNull;

import com.example.taras.privatinfo.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class LoggingInterceptor implements Interceptor {
    private final Interceptor mLoggingInterceptor;

    private LoggingInterceptor() {
        mLoggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        //.setLevel(Level.HEADERS);
    }

    @NonNull
    public static Interceptor create() {
        return (Interceptor) new LoggingInterceptor();
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        return mLoggingInterceptor.intercept(chain);
    }
}
