package com.example.uday.barcodereader.additem;

import com.example.uday.barcodereader.signup.PostModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by uday on 25/1/18.
 */

public interface APIServiceAddItem {
    @POST("api/v1/products")
    @FormUrlEncoded
    Call<ProductModel> savePost(@Field("id") String barcode,
                             @Field("ptitle") String ptitle,
                             @Field("pdesc") String pdesc,
                             @Field("psize") String psize,
                             @Field("pqty") int pqty,
                             @Field("prate") int prate,
                             @Field("pcolor") String pcolor);

}
