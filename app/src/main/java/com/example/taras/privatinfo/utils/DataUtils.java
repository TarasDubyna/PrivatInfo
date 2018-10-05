package com.example.taras.privatinfo.utils;

import android.util.Log;

import com.example.taras.privatinfo.model.Device;
import com.example.taras.privatinfo.model.PrivatItem;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class DataUtils {
    private static final String LOG_TAG = DataUtils.class.getSimpleName();

    public static TreeMap<String, List<PrivatItem>> getSortedDevicesByCity(List<Device> deviceList){
        TreeMap<String, List<PrivatItem>> cityMap = new TreeMap<>();

        for (Device device : deviceList){
            String cityName = device.getCityRU();
            if (!cityMap.containsKey(cityName)){
                cityMap.put(cityName, new ArrayList<>());
            }
            cityMap.get(cityName).add(device);
        }
        Log.d(LOG_TAG, "getSortedDevicesByCity, cities num: " + cityMap.size());
        return cityMap;
    }

}
