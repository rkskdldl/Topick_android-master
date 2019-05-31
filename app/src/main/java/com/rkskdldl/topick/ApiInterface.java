package com.rkskdldl.topick;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {
    @Headers({"Accept: application/json"})
    @POST("/register")
     Call<Object> registerAPI(@Body  User user);

}
