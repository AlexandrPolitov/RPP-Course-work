package com.e.myapplication.BackendProcess;

import android.util.Log;

import com.e.myapplication.MainInterface;
import com.e.myapplication.Net.NetInterface;
import com.e.myapplication.pojo.Events;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataLoader implements MainInterface.intractor {

    @Override
    public void loadData(final onLoadDataListener listener) {

        NetInterface netInterface = GetRetrofit.getRetrofit().create(NetInterface.class);

        Call<Events> eventsCall = netInterface.getEvent();

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
}
