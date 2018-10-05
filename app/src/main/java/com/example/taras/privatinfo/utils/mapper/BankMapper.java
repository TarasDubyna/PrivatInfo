package com.example.taras.privatinfo.utils.mapper;

import com.example.taras.privatinfo.model.Bank;
import com.example.taras.privatinfo.model.Device;
import com.example.taras.privatinfo.realm.model.BankDB;
import com.example.taras.privatinfo.realm.model.DeviceDB;

import rx.functions.Func1;

public class BankMapper implements Func1<BankDB, Bank> {

    @Override
    public Bank call(BankDB bank) {
        return new Bank(bank.getType(),
                bank.getName(),
                bank.getState(),
                bank.getId(),
                bank.getCountry(),
                bank.getCity(),
                bank.getIndex(),
                bank.getPhone(),
                bank.getEmail(),
                bank.getAddress());
    }
}
