package com.example.taras.privatinfo.utils;

import android.support.annotation.NonNull;

import com.google.gson.JsonObject;

public class JsonUtils {

    private static final String CITY = "city";
    private static final String ADDRESS = "address";

    @NonNull
    public static JsonObject createGetAllBanksParam(){
        JsonObject param = new JsonObject();
        param.addProperty(CITY, "");
        param.addProperty(ADDRESS, "");
        return param;
    }

    @NonNull
    public static JsonObject createGetAllBanksByCityParam(String city){
        JsonObject param = new JsonObject();
        param.addProperty(CITY, city);
        param.addProperty(ADDRESS, "");
        return param;
    }



}
