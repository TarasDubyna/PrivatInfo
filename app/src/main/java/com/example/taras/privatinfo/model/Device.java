package com.example.taras.privatinfo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Device extends PrivatItem{
    /*@SerializedName("type")
    @Expose
    private String type;*/

    @SerializedName("cityRU")
    @Expose
    private String cityRU;
    @SerializedName("cityUA")
    @Expose
    private String cityUA;
    @SerializedName("cityEN")
    @Expose
    private String cityEN;
    @SerializedName("fullAddressRu")
    @Expose
    private String fullAddressRu;
    @SerializedName("fullAddressUa")
    @Expose
    private String fullAddressUa;
    @SerializedName("fullAddressEn")
    @Expose
    private String fullAddressEn;
    @SerializedName("placeRu")
    @Expose
    private String placeRu;
    @SerializedName("placeUa")
    @Expose
    private String placeUa;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("tw")
    @Expose
    private Day day;

    public Device(String type, String cityRU, String cityUA, String cityEN, String fullAddressRu, String fullAddressUa, String fullAddressEn, String placeRu, String placeUa, String latitude, String longitude, Day day) {
        super(type);
        this.cityRU = cityRU;
        this.cityUA = cityUA;
        this.cityEN = cityEN;
        this.fullAddressRu = fullAddressRu;
        this.fullAddressUa = fullAddressUa;
        this.fullAddressEn = fullAddressEn;
        this.placeRu = placeRu;
        this.placeUa = placeUa;
        this.latitude = latitude;
        this.longitude = longitude;
        this.day = day;
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

    public void setTw(Day day) {
        this.day = day;
    }

}
