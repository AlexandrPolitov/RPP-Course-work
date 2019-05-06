package com.e.myapplication.pojo.Event;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("dates")
    @Expose
    private List<Date> dates = null;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("place")
    @Expose
    private Place place;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("site_url")
    @Expose
    private String siteUrl;

    public List<Date> getDates() {
        return dates;
    }
    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Place getPlace() {
        return place;
    }
    public void setPlace(Place place) {
        this.place = place;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public List<Image> getImages() {
        return images;
    }
    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getSiteUrl() {
        return siteUrl;
    }
    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
}
