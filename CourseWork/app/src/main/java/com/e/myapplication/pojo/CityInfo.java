package com.e.myapplication.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityInfo {
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("coords")
    @Expose
    private Coords coords;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("currency")
    @Expose
    private String currency;

    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTimezone() {
        return timezone;
    }
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Coords getCoords() {
        return coords;
    }
    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
