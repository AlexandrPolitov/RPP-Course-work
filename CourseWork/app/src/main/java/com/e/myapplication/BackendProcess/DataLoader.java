package com.e.myapplication.BackendProcess;

import android.util.Log;

import com.e.myapplication.MainInterface;
import com.e.myapplication.Net.NetInterface;
import com.e.myapplication.R;
import com.e.myapplication.pojo.City;
import com.e.myapplication.pojo.Events;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataLoader implements MainInterface.intractor {

    onLoadDataListener listener;

    @Override
    public void loadData(final onLoadDataListener listener, int itemId) {
        this.listener = listener;

        NetInterface netInterface = GetRetrofit.getRetrofit().create(NetInterface.class);
        Call<Events> eventsCall;
        Call<List<City>> citiesCall;

        switch (itemId) {
            case R.id.eventsItem:
                eventsCall = netInterface.getEvent();
                handleEventCallback(eventsCall);
                break;
            case R.id.cityItem:
                citiesCall = netInterface.getCities("ru");
                handleCitiesCallback(citiesCall);
                break;

                default:
                    eventsCall = netInterface.getEvent();
                    handleEventCallback(eventsCall);
        }



    }

    public void handleEventCallback(Call<Events> eventsCall) {
        eventsCall.enqueue(new Callback<Events>() {
            @Override
            public void onResponse(Call<Events> call, Response<Events> response) {
                listener.onLoadEventFinished(response.body());
            }

            @Override
            public void onFailure(Call<Events> call, Throwable t) {
                Log.e("ServerLoadError", t.toString());
            }
        });
    }

    public void handleCitiesCallback(Call<List<City>> citiesCall) {
        citiesCall.enqueue(new Callback<List<City>>() {
            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                listener.onLoadCitiesFinished(response.body());
            }

            @Override
            public void onFailure(Call<List<City>> call, Throwable t) {

            }
        });
    }
}
