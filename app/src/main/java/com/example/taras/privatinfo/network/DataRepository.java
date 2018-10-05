package com.example.taras.privatinfo.network;

import com.example.taras.privatinfo.model.Bank;
import com.example.taras.privatinfo.model.Device;
import com.example.taras.privatinfo.network.repository.Repository;
import com.example.taras.privatinfo.network.response.DeviceResponse;
import com.example.taras.privatinfo.realm.AtmCacheTransformer;
import com.example.taras.privatinfo.realm.BankCacheTransformer;
import com.example.taras.privatinfo.realm.TerminalCacheTransformer;
import com.example.taras.privatinfo.realm.model.BankDB;
import com.example.taras.privatinfo.utils.mapper.BankMapper;
import com.example.taras.privatinfo.utils.mapper.DeviceMapper;

import java.util.List;

import rx.Observable;
import ru.arturvasilov.rxloader.RxUtils;

public class DataRepository implements Repository {

    @Override
    public Observable<List<Bank>> getAllBanks() {
        return ApiFactory.getRetrofitService()
                .getAllBanks("", "")
                .compose(new BankCacheTransformer())
                .flatMap(Observable::from)
                .map(new BankMapper())
                .toList()
                .compose(RxUtils.async());
    }


    @Override
    public Observable<List<Device>> getAllTerminals() {
        return ApiFactory.getRetrofitService()
                .getAllTerminals("", "")
                .map(DeviceResponse::getDevices)
                .compose(new TerminalCacheTransformer())
                .flatMap(Observable::from)
                .map(new DeviceMapper())
                .toList()
                .compose(RxUtils.async());
    }

    @Override
    public Observable<List<Device>> getAllATMs() {
        return ApiFactory.getRetrofitService()
                .getAllAtms("", "")
                .map(DeviceResponse::getDevices)
                .compose(new AtmCacheTransformer())
                .flatMap(Observable::from)
                .map(new DeviceMapper())
                .toList()
                .compose(RxUtils.async());
    }


}
