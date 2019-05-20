package com.e.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.e.myapplication.pojo.Event.Result;
import com.e.myapplication.pojo.Events;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.EventViewHolder> {
    List<Result> list;

    public MyAdapter(Events events) {
        list = events.getResults();
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.EventViewHolder eventViewHolder, int i) {
        eventViewHolder.imageView.set
    }

    @NonNull
    @Override
    public MyAdapter.EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class EventViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView description;

        public EventViewHolder(View v) {
            super(v);
            imageView = v.findViewById(R.id.cover_event);
            title = v.findViewById(R.id.title_event);
            description = v.findViewById(R.id.description_event);
        }

    }
}
