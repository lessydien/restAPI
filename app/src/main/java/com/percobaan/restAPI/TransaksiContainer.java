package com.percobaan.restAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransaksiContainer {

    @SerializedName("TransaksiObject")
    @Expose
    private List<TransaksiObject> transaksiObject = null;

    public List<TransaksiObject> getTransaksiObject() {
        return transaksiObject;
    }

    public void setTransaksiObject(List<TransaksiObject> transaksiObject) {
        this.transaksiObject = transaksiObject;
    }

}
