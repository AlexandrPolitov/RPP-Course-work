package com.e.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.e.myapplication.pojo.Event.Result;
import com.e.myapplication.pojo.Events;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.EventViewHolder> {
    List<Result> list;
    Context mContext;

    public MyAdapter(Events events, Context mContext) {
        list = events.getResults();
        this.mContext = mContext;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.EventViewHolder eventViewHolder, int i) {
        Result result = list.get(i);
        Glide.with(mContext).load(result.getImages().get(0)).into(eventViewHolder.imageView);
    }

    @NonNull
    @Override
    public MyAdapter.EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_card_view,viewGroup,false);
        return new EventViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
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
