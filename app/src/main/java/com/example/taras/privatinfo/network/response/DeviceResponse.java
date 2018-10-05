package com.example.taras.privatinfo.network.response;

import com.example.taras.privatinfo.model.Device;
import com.example.taras.privatinfo.realm.model.DeviceDB;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DeviceResponse {
    @SerializedName("devices")
    private List<DeviceDB> mDevicesResponse;

    public List<DeviceDB> getDevices() {
        if (mDevicesResponse == null) {
            return new ArrayList<>();
        }
        return mDevicesResponse;
    }
}
