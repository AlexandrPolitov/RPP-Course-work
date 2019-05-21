package com.e.myapplication;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.e.myapplication.Net.NetInterface;
import com.e.myapplication.pojo.Event.Result;
import com.e.myapplication.pojo.Events;

import java.util.ArrayList;
import java.util.List;

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

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle barToggle;

    List<Result> list;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get backend from KudaGo
        getBackendInfo();

        //Initializing of sideBar
        drawerLayout = findViewById(R.id.drawerLayout);
        barToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(barToggle);
        barToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(barToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadMainBoard() {
        recyclerView = findViewById(R.id.items_recycler_view);
        MyAdapter myAdapter = new MyAdapter(this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter.addAll(events);
        myAdapter.notifyDataSetChanged();
    }
    private void getBackendInfo() {
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
