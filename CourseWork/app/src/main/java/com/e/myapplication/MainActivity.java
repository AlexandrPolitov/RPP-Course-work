package com.e.myapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.e.myapplication.Adapters.EventsAdapter;
import com.e.myapplication.BackendProcess.BackendPresenter;
import com.e.myapplication.BackendProcess.DataLoader;
import com.e.myapplication.pojo.City;
import com.e.myapplication.pojo.Event.Result;
import com.e.myapplication.pojo.Events;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainInterface.mainView{


    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle barToggle;

    List<Result> list;
    RecyclerView recyclerView;
    EventsAdapter myAdapter;

    //Интерфейс, который умеет загружать данные
    MainInterface.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        //Инициализируем выпадающее меню
        drawerLayout = findViewById(R.id.drawerLayout);
        barToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);

        //Устанавливаем кнопку
        drawerLayout.addDrawerListener(barToggle);
        barToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.items_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        presenter = new BackendPresenter(this, new DataLoader());
        presenter.getDataFromServer();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Toast.makeText(MainActivity.this, "Events Clicked",Toast.LENGTH_LONG);

        switch (menuItem.getItemId()) {
            case R.id.eventsItem:
                Toast.makeText(MainActivity.this, "Events Clicked",Toast.LENGTH_LONG).show();
                myAdapter.clear();
                myAdapter.notifyDataSetChanged();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(barToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setEventsToRecyclerView(Events events) {

        myAdapter = new EventsAdapter(MainActivity.this);

        Log.i("ATTACHING", "STAAARRRT");

        recyclerView.setAdapter(myAdapter);
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        myAdapter.addAll(events);
        myAdapter.notifyDataSetChanged();

        Log.i("ATTACHING", "FINISHEEEED");

    }

    @Override
    public void setCityToRecyclerView(List<City> cities) {

    }
}
