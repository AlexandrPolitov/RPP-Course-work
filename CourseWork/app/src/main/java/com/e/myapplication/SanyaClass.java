package com.e.myapplication;

import java.util.List;
import retrofit2.Call;
import android.util.Log;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import java.util.ArrayList;
import com.e.myapplication.pojo.City;
import com.e.myapplication.pojo.Category;
import com.e.myapplication.Net.NetInterface;
import com.e.myapplication.pojo.CityInfo;
import com.e.myapplication.pojo.Events;
import retrofit2.converter.gson.GsonConverterFactory;

public class SanyaClass {

    // https://kudago.com/public-api/v1.2/events/?fields=dates,title,place,location,price,images,site_url

    private static final String URL_JSON = "https://kudago.com/public-api/v1.2/";
    private NetInterface netInterface;
    private Retrofit retrofit;
    private Events events;
    private CityInfo cityInfo;
    private List<Category> categories = new ArrayList<>();
    private List<City> cities = new ArrayList<>();

    public Events getEvent() {
            retrofit = new Retrofit.Builder().baseUrl(URL_JSON)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            netInterface = retrofit.create(NetInterface.class);

            netInterface.getEvent().enqueue(new Callback<Events>() {
                @Override
                public void onResponse(Call<Events> call, Response<Events> response) {
                    events = response.body();
                }

                @Override
                public void onFailure(Call<Events> call, Throwable t) {
                    Log.e("Error", "");
                }
            });
        return events;
    }

    public Events getEvents(String category, String city) {
            retrofit = new Retrofit.Builder().baseUrl(URL_JSON)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            netInterface = retrofit.create(NetInterface.class);

            netInterface.getEvents(category, city).enqueue(new Callback<Events>() {
                @Override
                public void onResponse(Call<Events> call, Response<Events> response) {
                    events = response.body();
                }

                @Override
                public void onFailure(Call<Events> call, Throwable t) {
                    Log.e("Error", "");
                }
            });
        return events;
    }
    public List<Category> getCategories(String language) {
        retrofit = new Retrofit.Builder().baseUrl(URL_JSON)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        netInterface = retrofit.create(NetInterface.class);

        netInterface.getCategories(language).enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                categories.addAll(response.body());
            }
            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.e("Error","");
            }
        });
        return categories;
    }
    public List<City> getCities(String language) {

        retrofit = new Retrofit.Builder().baseUrl(URL_JSON)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        netInterface = retrofit.create(NetInterface.class);

        netInterface.getCities(language).enqueue(new Callback<List<City>>() {
            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                cities.addAll(response.body());
            }
            @Override
            public void onFailure(Call<List<City>> call, Throwable t) {
                Log.e("Error","");
            }
        });
        return cities;
    }
    public CityInfo getCityInfo(String city) {

        retrofit = new Retrofit.Builder().baseUrl(URL_JSON)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        netInterface = retrofit.create(NetInterface.class);

        netInterface.getCityInfo(city).enqueue(new Callback<CityInfo>() {
            @Override
            public void onResponse(Call<CityInfo> call, Response<CityInfo> response) {
                cityInfo = response.body();
            }
            @Override
            public void onFailure(Call<CityInfo> call, Throwable t) {
                Log.e("Error","");
            }
        });
        return cityInfo;
    }
}
