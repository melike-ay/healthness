package com.example.project1;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("v1/nutrition")
    Call<ResponseModel> getNutritionData(@Query("query") String query);
}

