package com.example.uday.barcodereader.barcodemodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by uday on 14/1/18.
 */

public class Result {
    @SerializedName("barcode")
    String barcode;
    @SerializedName("details")
    ProductDetails productDetails;
    @SerializedName("images")
    ProductImage productImage;

    public Result(String barcode, ProductDetails productDetails, ProductImage productImage) {
        this.barcode = barcode;
        this.productDetails = productDetails;
        this.productImage = productImage;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public ProductImage getProductImage() {
        return productImage;
    }

    public void setProductImage(ProductImage productImage) {
        this.productImage = productImage;
    }
}
