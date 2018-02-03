package com.example.uday.barcodereader.signup;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by uday on 25/1/18.
 */

public interface APIService {
    @POST("api/v1/vendors")
    @FormUrlEncoded
    Call<PostModel> savePost(@Field("id") String vid,
                             @Field("vname") String vname,
                             @Field("vmobile") String vmobile,
                             @Field("vemail") String vemail);

}
