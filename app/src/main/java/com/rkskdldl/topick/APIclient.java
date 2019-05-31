package com.rkskdldl.topick;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIclient {
    private static Retrofit retrofit =null;

    public  static Retrofit getClient(){
        if(retrofit==null){
            Gson gson =new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit= new Retrofit.Builder()
                    .baseUrl("http://topick.cafe24app.com")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
