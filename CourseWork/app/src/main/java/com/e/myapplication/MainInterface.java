package com.e.myapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import com.e.myapplication.pojo.City;
import com.e.myapplication.pojo.Events;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface MainInterface {

    //Отвечает за получение данных. Реализуется в специальном классе для делов с бэкендом
    interface presenter {
        void getDataFromServer();
    }

    //Отвечает за визуальное наполнение. Реализуется в MainActivity
    interface mainView extends NavigationView.OnNavigationItemSelectedListener {
        void setEventsToRecyclerView(Events events);
        void setCityToRecyclerView(List<City> cities);

        @Override
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    //Отвечает, какие данные и как будут загружаться в фоне.
    interface intractor {

        //Решает, как должна вести себя программа, когда данные загружены с сервера
        interface onLoadDataListener {
            void onLoadEventFinished(Events events);
            void onLoadCitiesFinished(List<City> cities);
        }

        //Инициализиацирует ретрофит, получает данные и передает их
        //onLoadDataLister, который знает, как с ними обращаться
        void loadData(onLoadDataListener listener);
    }
}
