package com.aditya.wisatasemarang.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {

    public static ApiSevice getApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://web-wisata.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiSevice service =retrofit.create(ApiSevice.class);
        return service;
    }
}
