package com.example.bored.remote_data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    private static DaApi instance;
    private RetrofitBuilder(){

    }
    public static DaApi getInstance(){
        if (instance == null)

        {
            instance = initIntance();

        }
        return instance;
    }
    private static DaApi initIntance()
    {
        return new Retrofit
                .Builder()
                .baseUrl("https://www.boredapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DaApi.class);


    }
}
