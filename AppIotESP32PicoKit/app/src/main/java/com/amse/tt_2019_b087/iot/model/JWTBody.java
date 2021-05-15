package com.amse.tt_2019_b087.iot.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JWTBody {


    @SerializedName("sub")
    @Expose
    private String sub;

    @SerializedName("iat")
    @Expose
    private Long iat;

    @SerializedName("exp")
    @Expose
    private Long exp;

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public Long getIat() {
        return iat;
    }

    public void setIat(Long iat) {
        this.iat = iat;
    }

    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "JWTBody{" +
                "sub='" + sub + '\'' +
                ", iat=" + iat +
                ", exp=" + exp +
                '}';
    }
}