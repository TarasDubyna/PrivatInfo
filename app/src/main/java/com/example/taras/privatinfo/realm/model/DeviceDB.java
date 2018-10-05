package com.example.taras.privatinfo.realm.model;

import com.example.taras.privatinfo.model.Day;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

@RealmClass
public class DeviceDB extends RealmObject {

    @SerializedName("type")
    private String type;
    @SerializedName("cityRU")
    private String cityRU;
    @SerializedName("cityUA")
    private String cityUA;
    @SerializedName("cityEN")
    private String cityEN;
    @SerializedName("fullAddressRu")
    private String fullAddressRu;
    @SerializedName("fullAddressUa")
    private String fullAddressUa;
    @SerializedName("fullAddressEn")
    private String fullAddressEn;
    @SerializedName("placeRu")
    private String placeRu;
    @SerializedName("placeUa")
    private String placeUa;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("tw")
    private Day day;

    public DeviceDB() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCityRU() {
        return cityRU;
    }

    public void setCityRU(String cityRU) {
        this.cityRU = cityRU;
    }

    public String getCityUA() {
        return cityUA;
    }

    public void setCityUA(String cityUA) {
        this.cityUA = cityUA;
    }

    public String getCityEN() {
        return cityEN;
    }

    public void setCityEN(String cityEN) {
        this.cityEN = cityEN;
    }

    public String getFullAddressRu() {
        return fullAddressRu;
    }

    public void setFullAddressRu(String fullAddressRu) {
        this.fullAddressRu = fullAddressRu;
    }

    public String getFullAddressUa() {
        return fullAddressUa;
    }

    public void setFullAddressUa(String fullAddressUa) {
        this.fullAddressUa = fullAddressUa;
    }

    public String getFullAddressEn() {
        return fullAddressEn;
    }

    public void setFullAddressEn(String fullAddressEn) {
        this.fullAddressEn = fullAddressEn;
    }

    public String getPlaceRu() {
        return placeRu;
    }

    public void setPlaceRu(String placeRu) {
        this.placeRu = placeRu;
    }

    public String getPlaceUa() {
        return placeUa;
    }

    public void setPlaceUa(String placeUa) {
        this.placeUa = placeUa;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
