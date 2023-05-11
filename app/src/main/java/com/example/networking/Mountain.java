package com.example.networking;

import com.google.gson.annotations.SerializedName;

public class Mountain {
    @SerializedName("ID")
    private String ID;
    @SerializedName("name")
    private String name;
    @SerializedName("cost")
    private int feet;
    @SerializedName("size")
    private int meter;

    public String getName() {
        return name;
    }
}
