package com.example.uday.barcodereader.barcodemodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by uday on 14/1/18.
 */

public class ProductResponse {
    @SerializedName("status")
    int status;
    @SerializedName("result")
    public List<Result> result;

    public ProductResponse(int status, List<Result> result) {
        this.status = status;
        this.result = result;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }




}
