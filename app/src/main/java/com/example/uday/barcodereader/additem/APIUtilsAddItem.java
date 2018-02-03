package com.example.uday.barcodereader.additem;



/**
 * Created by uday on 25/1/18.
 */

public class APIUtilsAddItem {
    private APIUtilsAddItem() {}

    public static final String BASE_URL = "http://192.168.0.32:3000/";

    public static APIServiceAddItem getAPIService() {

        return RetrofitClientAddItem.getClient(BASE_URL).create(APIServiceAddItem.class);
    }
}
