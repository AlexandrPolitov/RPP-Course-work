package com.e.myapplication.pojo.Event;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Place {
    @SerializedName("id")
    @Expose
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}