package com.example.uday.barcodereader.mainactivityfragments;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by uday on 12/12/17.
 */

public interface ApiInterface {

    @GET("api/v1/products/")
     Call<ProoductResponse> getAllproducts(@Query("sid") String sid);


}
