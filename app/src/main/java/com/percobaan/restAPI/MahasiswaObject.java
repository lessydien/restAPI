package com.percobaan.restAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MahasiswaObject {

    @Expose
    @SerializedName("id")
    private Integer id;

    @Expose
    @SerializedName("nama")
    private String nama;

    @Expose
    @SerializedName("pass")
    private String pass;

    @Expose
    @SerializedName("alamat")
    private String alamat;


    public MahasiswaObject(Integer id, String nama, String pass, String alamat) {
        this.id = id;
        this.nama = nama;
        this.pass = pass;
        this.alamat = alamat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "MahasiswaObject{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", pass='" + pass + '\'' +
                ", alamat='" + alamat + '\'' +
                '}';
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }



}
