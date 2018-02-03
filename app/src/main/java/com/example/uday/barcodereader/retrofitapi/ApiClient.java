package com.example.uday.barcodereader.retrofitapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by uday on 14/1/18.
 */

public class ApiClient {
    public static final String BASE_URL ="https://www.barcodelookup.com/";
    private static Retrofit retrofit =null;
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
