package com.example.uday.barcodereader.mainactivityfragments;

import com.google.gson.annotations.SerializedName;

/**
 * Created by uday on 4/2/18.
 */

public class Product {
    @SerializedName("id")
    String id;
    @SerializedName("sid")
    String sid;
    @SerializedName("ptitle")
    String ptitle;
    @SerializedName("pcolor")
    String pcolor;
    @SerializedName("pdesc")
    String pdesc;
    @SerializedName("psize")
    String psize;
    @SerializedName("pqty")
    String pqty;
    @SerializedName("prate")
    String prate;

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

    public String getPcolor() {
        return pcolor;
    }

    public void setPcolor(String pcolor) {
        this.pcolor = pcolor;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getPsize() {
        return psize;
    }

    public void setPsize(String psize) {
        this.psize = psize;
    }

    public String getPqty() {
        return pqty;
    }

    public void setPqty(String pqty) {
        this.pqty = pqty;
    }

    public String getPrate() {
        return prate;
    }

    public void setPrate(String prate) {
        this.prate = prate;
    }
}
