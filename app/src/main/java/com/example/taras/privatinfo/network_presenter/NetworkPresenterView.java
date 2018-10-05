package com.example.taras.privatinfo.network_presenter;

import com.example.taras.privatinfo.model.Bank;
import com.example.taras.privatinfo.model.Device;

import java.util.List;

public interface NetworkPresenterView {

    void getAllBanks(List<Bank> list);
    void getAllATMs(List<Device> response);
    void getAllTerminals(List<Device> response);

    void showError(Throwable throwable);

    void allLoadingAreEnded();
}
