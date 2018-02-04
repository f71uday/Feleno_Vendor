package com.example.uday.barcodereader.mainactivityfragments;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by uday on 4/2/18.
 */

public class ProoductResponse {
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String msg;
    @SerializedName("data")

    List<Product> productList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Product> getList() {
        return productList;
    }

    public void setList(List<Product> productlist) {
        this.productList = productList;
    }


}
