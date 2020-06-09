package com.percobaan.restAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MahasiswaContainer {


    @SerializedName("MahasiswaObject")
    @Expose
    private List<MahasiswaObject> mahasiswaObject = null;

    public void setMahasiswaObject(List<MahasiswaObject> mahasiswaObject) {
        this.mahasiswaObject = mahasiswaObject;
    }
    public List<MahasiswaObject> getMahasiswaObject() {
        return mahasiswaObject;
    }

}
