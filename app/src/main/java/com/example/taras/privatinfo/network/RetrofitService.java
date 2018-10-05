package com.example.taras.privatinfo.network;

import com.example.taras.privatinfo.model.Bank;
import com.example.taras.privatinfo.network.response.DeviceResponse;
import com.example.taras.privatinfo.realm.model.BankDB;

import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RetrofitService {


    //https://api.privatbank.ua/p24api/infrastructure?json&tso&address=&city=


    @GET("pboffice?json&")
    Observable<List<BankDB>> getAllBanks(@Query("address") String address,
                                         @Query("city") String city);

    @GET("infrastructure?json&atm&")
    Observable<DeviceResponse> getAllAtms(@Query("address") String address,
                                          @Query("city") String city);

    @GET("infrastructure?json&tso&")
    Observable<DeviceResponse> getAllTerminals(@Query("address") String address,
                                                @Query("city") String city);
}
