package com.example.taras.privatinfo.network.repository;

import com.example.taras.privatinfo.model.Bank;
import com.example.taras.privatinfo.model.Device;

import java.util.List;

import rx.Observable;

public interface Repository {

    Observable<List<Bank>> getAllBanks();
    Observable<List<Device>> getAllTerminals();
    Observable<List<Device>> getAllATMs();
}
