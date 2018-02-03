package com.example.uday.barcodereader.retrofitapi;

import com.example.uday.barcodereader.barcodemodel.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by uday on 14/1/18.
 */

public interface Apiinteface {
    @GET("restapi")
    Call<ProductResponse> getProductDetails(@Query("key") String key,@Query("barcode") String barcode);

}
