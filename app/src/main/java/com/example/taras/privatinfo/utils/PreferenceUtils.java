package com.example.taras.privatinfo.utils;

import com.orhanobut.hawk.Hawk;

public class PreferenceUtils {

    private static final String LAST_TIMESTAMP_UPDATE = "LAST_TIMESTAMP_UPDATE";

    public static void saveLastTimestampUpdate(long timestamp) {
        Hawk.put(LAST_TIMESTAMP_UPDATE, timestamp);
    }

    public static long getLastTimestampUpdate() {
        return Hawk.get(LAST_TIMESTAMP_UPDATE, 0L);
    }

}
