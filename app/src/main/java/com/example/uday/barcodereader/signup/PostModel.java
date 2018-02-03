package com.example.uday.barcodereader.signup;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by uday on 25/1/18.
 */

public class PostModel {
    @SerializedName("id")
    @Expose
    private String vid;
    @SerializedName("vname")
    @Expose
    private String vname;
    @SerializedName("vmobile")
    @Expose
    private String vmobile;
    @SerializedName("vemail")
    @Expose
    private String vemail;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVmobile() {
        return vmobile;
    }

    public void setVmobile(String vmobile) {
        this.vmobile = vmobile;
    }

    public String getVemail() {
        return vemail;
    }

    public void setVemail(String vemail) {
        this.vemail = vemail;
    }

}
