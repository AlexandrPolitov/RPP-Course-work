package com.e.myapplication.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.e.myapplication.R;
import com.e.myapplication.pojo.Event.Result;
import com.e.myapplication.pojo.Events;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder> {
    List<Result> list;
    Context mContext;

    public EventsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void clear() {
        list.clear();
    }

    public void addAll(Events events) {
        list = events.getResults();
        Log.i("adapter",list.get(0).getTitle());
    }

    @Override
    public void onBindViewHolder(@NonNull EventsAdapter.EventViewHolder eventViewHolder, int i) {
        Result result = list.get(i);
        long eventStart = result.getDates().get(0).getStart();
        long eventEnd = result.getDates().get(0).getEnd();
        Date eventStartDate = new Date(eventStart*1000);
        Date eventEndDate = new Date(eventEnd*1000);

        SimpleDateFormat eventDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat eventHourFormat = new SimpleDateFormat("HH:mm");

        eventViewHolder.title.setText(result.getTitle());
        eventViewHolder.date.setText(eventDateFormat.format(eventStartDate));
        Log.i("date","starts " + result.getDates().get(0).getStart());
        Log.i("date","ends " + result.getDates().get(0).getEnd());
        eventViewHolder.location.setText(result.getLocation().getSlug() + " (" + eventHourFormat.format(eventStartDate) + ") ");
        Glide.with(mContext).load(result.getImages().get(0).getImage()).into(eventViewHolder.imageView);
    }

    @NonNull
    @Override
    public EventsAdapter.EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_card_view,viewGroup,false);
        return new EventViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView date;
        TextView location;

        public EventViewHolder(View v) {
            super(v);
            imageView = v.findViewById(R.id.cover_event);
            title = v.findViewById(R.id.title_event);
            date = v.findViewById(R.id.date_event);
            location = v.findViewById(R.id.location_event);
        }

    }
}
