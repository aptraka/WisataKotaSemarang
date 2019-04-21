package com.aditya.wisatasemarang.retrofit;

import com.aditya.wisatasemarang.models.WisataResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiSevice {
    @GET("api")
    Call<WisataResponse> ambilData();
}
