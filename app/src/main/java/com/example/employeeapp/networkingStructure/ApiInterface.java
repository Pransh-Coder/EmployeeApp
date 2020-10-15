package com.example.employeeapp.networkingStructure;

import com.example.employeeapp.model.Example;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("ShowAlloption")
    Call<Example>getAllOptions(@Body JsonObject jsonObject);

}
