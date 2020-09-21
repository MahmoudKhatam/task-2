package com.example.application.mytask2;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("repos")

    public Call<post> getpost();

}
