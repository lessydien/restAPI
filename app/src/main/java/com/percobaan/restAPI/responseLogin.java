package com.percobaan.restAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class responseLogin {
    @Override
    public String toString() {
        return "responseLogin{" +
                "login=" + login +
                '}';
    }

    @Expose
    @SerializedName("login")
    private Integer login;

    public responseLogin(Integer login) {
        this.login = login;
    }

    public Integer getLogin() {
        return login;
    }

    public void setLogin(Integer status_upload) {
        this.login = login;
    }
}
