package com.e.myapplication.pojo;

import java.util.List;

import com.e.myapplication.pojo.Event.Result;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Events {
    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("previous")
    @Expose
    private String previous;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }
    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }
    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Result> getResults() {
        return results;
    }
    public void setResults(List<Result> results) {
        this.results = results;
    }
}