package com.e.myapplication.BackendProcess;

import android.media.SoundPool;

import com.e.myapplication.MainInterface;
import com.e.myapplication.pojo.Events;

import java.util.ArrayList;

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
    public void getDataFromServer() {
        intractor.loadData(this);
    }

    //Говорим, как обращаться с данными с сервера
    @Override
    public void onLoadEventFinished(Events events) {
        mainView.setEventsToRecyclerView(events);
    }
}
