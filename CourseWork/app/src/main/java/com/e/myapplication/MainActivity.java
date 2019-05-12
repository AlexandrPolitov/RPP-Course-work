package com.e.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.e.myapplication.Net.NetInterface;
import com.e.myapplication.pojo.Events;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    SanyaClass sanya = new SanyaClass();



    private static final String URL_JSON = "https://kudago.com/public-api/v1.2/";
    private NetInterface netInterface;
    private Retrofit retrofit;
    private Events events;

    private ListView navigationList;
    private String[] navigationItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationItems = getResources().getStringArray(R.array.dima_sanya_go);
        navigationList = findViewById(R.id.left_drawer);

        navigationList.setAdapter(new ArrayAdapter<String>(this,R.layout.drawer_list_item, navigationItems));


        retrofit = new Retrofit.Builder().baseUrl(URL_JSON)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        netInterface = retrofit.create(NetInterface.class);

        netInterface.getEvent().enqueue(new Callback<Events>() {
            @Override
            public void onResponse(Call<Events> call, Response<Events> response) {
                events = response.body();
                if (!events.equals(null))
                      Log.e("my", "*** lvдl: " + String.valueOf(events.getCount()));
            }

            @Override
            public void onFailure(Call<Events> call, Throwable t) {
                Log.e("my", "ha hah");
            }
        });
    }
}
