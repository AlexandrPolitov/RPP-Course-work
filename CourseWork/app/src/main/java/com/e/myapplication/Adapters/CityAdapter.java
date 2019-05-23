package com.e.myapplication.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.e.myapplication.R;
import com.e.myapplication.pojo.City;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {
    List<City> cities;

    public void addAll(List<City> cities) {
        this.cities = cities;
    }

    @NonNull
    @Override
    public CityAdapter.CityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.city_recycler_item, viewGroup,false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityAdapter.CityViewHolder cityViewHolder, int i) {
        cityViewHolder.text.setText(cities.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class CityViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public CityViewHolder(View view) {
            super(view);
            text = view.findViewById(R.id.cityItemText);
        }
    }
}
