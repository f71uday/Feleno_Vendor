package com.example.uday.barcodereader.barcodemodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by uday on 14/1/18.
 */

public class ProductImage {
    @SerializedName("0")
    String imageUrl ;

    public ProductImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
