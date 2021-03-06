package com.e.myapplication.BackendProcess;

import android.media.SoundPool;

import com.e.myapplication.MainInterface;
import com.e.myapplication.R;
import com.e.myapplication.pojo.City;
import com.e.myapplication.pojo.Events;

import java.util.ArrayList;
import java.util.List;

public class BackendPresenter implements MainInterface.presenter, MainInterface.intractor.onLoadDataListener {

    //объект получателя данных с сервера
    MainInterface.intractor intractor;

    //объект преобразования данных в картинку
    MainInterface.mainView mainView;

    public BackendPresenter(MainInterface.mainView mainView, MainInterface.intractor intractor) {
        this.intractor = intractor;
        this.mainView = mainView;
    }


    //Запрашиваем данные с сервера
    @Override
    public void getDataFromServer(int itemId) {
        intractor.loadData(this, itemId);
    }

    //Говорим, как обращаться с данными с сервера
    @Override
    public void onLoadEventFinished(Events events) {
        mainView.setEventsToRecyclerView(events);
    }

    @Override
    public void onLoadCitiesFinished(List<City> cities) {
        mainView.setCityToRecyclerView(cities);
    }
}
