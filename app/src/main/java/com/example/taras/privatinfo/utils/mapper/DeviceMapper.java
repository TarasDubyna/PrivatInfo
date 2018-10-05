package com.example.taras.privatinfo.utils.mapper;

import com.example.taras.privatinfo.model.Device;
import com.example.taras.privatinfo.realm.model.DeviceDB;

import rx.functions.Func1;

public class DeviceMapper implements Func1<DeviceDB, Device> {

    @Override
    public Device call(DeviceDB device) {
        return new Device(device.getType(),
                device.getCityRU(),
                device.getCityUA(),
                device.getCityUA(),
                device.getFullAddressRu(),
                device.getFullAddressUa(),
                device.getFullAddressEn(),
                device.getPlaceRu(),
                device.getPlaceUa(),
                device.getLatitude(),
                device.getLongitude(),
                device.getDay());
    }



    public static Device convert(DeviceDB device){
        return new Device(device.getType(),
                device.getCityRU(),
                device.getCityUA(),
                device.getCityUA(),
                device.getFullAddressRu(),
                device.getFullAddressUa(),
                device.getFullAddressEn(),
                device.getPlaceRu(),
                device.getPlaceUa(),
                device.getLatitude(),
                device.getLongitude(),
                device.getDay());
    }
}
