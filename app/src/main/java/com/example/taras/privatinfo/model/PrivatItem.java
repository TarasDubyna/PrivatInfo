package com.example.taras.privatinfo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrivatItem {

    @SerializedName("type")
    @Expose
    private String type;

    public PrivatItem(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
