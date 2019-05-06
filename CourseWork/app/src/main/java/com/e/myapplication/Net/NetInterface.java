package com.e.myapplication.Net;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import com.e.myapplication.pojo.City;
import com.e.myapplication.pojo.CityInfo;
import com.e.myapplication.pojo.Events;
import com.e.myapplication.pojo.Category;

public interface NetInterface {
    @GET("events/?fields=dates,title,place,location,price,images,site_url")
    Call<Events> getEvent();

    @GET("events/?fields=dates,title,place,location,price,images,site_url")
    Call<Events> getEvents(@Query("&categories") String category, @Query("&city") String city);

    @GET("event-categories/?")
    Call<List<Category>> getCategories(@Query("lang") String lang);

    @GET("locations/?")
    Call<List<City>> getCities(@Query("lang") String lang);

    @GET("locations/{city}/")
    Call<CityInfo> getCityInfo(@Path("city") String city);
}
