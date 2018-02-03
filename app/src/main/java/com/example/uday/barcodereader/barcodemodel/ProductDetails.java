package com.example.uday.barcodereader.barcodemodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by uday on 14/1/18.
 */

public class ProductDetails {
    @SerializedName( "product_name")
    String productName;
    @SerializedName("long_description")
    String longDiscription;
    @SerializedName("prod_details")
    String productDetails;
    @SerializedName("model")
    String model;

    public String getProductWeight() {
        return productWeight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    @SerializedName("weight")
    String productWeight;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLongDiscription() {
        return longDiscription;
    }

    public void setLongDiscription(String longDiscription) {
        this.longDiscription = longDiscription;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }



    public ProductDetails(String productName, String longDiscription, String productDetails, String
            productWeight,String model)
    {
            this.longDiscription =longDiscription;
            this.productDetails  = productDetails;
            this.productName = productName;
            this.productWeight =productWeight;
            this.model=model;
    }
}
