package com.percobaan.restAPI;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;


public class RestRepo {

    private MahasiswaObject mahasiswaObject;
    private MahasiswaContainer mahasiswaContainer;


    private List<MahasiswaObject> MahasiswaList = new ArrayList<>();
    private PostToCloud connectToAPI;


    public RestRepo() {
        connectToAPI = retroofitInstance.getRetrofitInstance().create(PostToCloud.class);
    }

    public void setMahasiswaObject(List<MahasiswaObject> myList){
        this.MahasiswaList = myList;
    }

    public Call<responseLogin>  loginMahasiswa(MahasiswaObject mahasiswaObject) {
        return connectToAPI.loginMahasiswa(mahasiswaObject);
    }

    public Call<MahasiswaContainer>  getMahasiswa() {
        return connectToAPI.getMahasiswa();
    }


}
