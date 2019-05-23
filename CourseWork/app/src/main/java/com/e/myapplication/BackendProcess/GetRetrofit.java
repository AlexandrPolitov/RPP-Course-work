package com.e.myapplication.BackendProcess;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetRetrofit {
    private static final String URL_JSON = "https://kudago.com/public-api/v1.2/";
    static Retrofit retrofit;
    public static Retrofit getRetrofit(){
        retrofit = new Retrofit.Builder().baseUrl(URL_JSON)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
