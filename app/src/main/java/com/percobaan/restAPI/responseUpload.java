package com.percobaan.restAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class responseUpload {
    @Expose
    @SerializedName("status_upload")
    private Integer status_upload;

    public responseUpload(Integer status_upload) {
        this.status_upload = status_upload;
    }

    public Integer getStatus_upload() {
        return status_upload;
    }

    public void setStatus_upload(Integer status_upload) {
        this.status_upload = status_upload;
    }
}
