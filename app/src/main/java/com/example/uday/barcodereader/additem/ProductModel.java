package com.example.uday.barcodereader.additem;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by uday on 25/1/18.
 */

public class ProductModel {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("sid")
    @Expose
    private String sid;
    @SerializedName("ptitle")
    @Expose
    private String ptitle;
    @SerializedName("psize")
    @Expose
    private String psize;
    @SerializedName("pqty")
    @Expose
    private Integer pqty;
    @SerializedName("prate")
    @Expose
    private Integer prate;
    @SerializedName("pdesc")
    @Expose
    private String pdesc;
    @SerializedName("pcolor")
    @Expose
    private String pcolor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getPsize() {
        return psize;
    }

    public void setPsize(String psize) {
        this.psize = psize;
    }

    public Integer getPqty() {
        return pqty;
    }

    public void setPqty(Integer pqty) {
        this.pqty = pqty;
    }

    public Integer getPrate() {
        return prate;
    }

    public void setPrate(Integer prate) {
        this.prate = prate;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getPcolor() {
        return pcolor;
    }

    public void setPcolor(String pcolor) {
        this.pcolor = pcolor;
    }

}
