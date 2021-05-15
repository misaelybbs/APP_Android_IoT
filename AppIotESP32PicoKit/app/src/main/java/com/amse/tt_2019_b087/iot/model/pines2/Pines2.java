package com.amse.tt_2019_b087.iot.model.pines2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Pines2 {

    @SerializedName("pines")
    @Expose
    private List<Pines2> pines2 = new ArrayList<>();

    public List<Pines2> getPines2() {
        return pines2;
    }

    public void setPines2(List<Pines2> pines2) {
        this.pines2 = pines2;
    }
}
