package com.percobaan.restAPI;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface PostToCloud {
    @POST("ujianandroid/login.php")
    Call<responseLogin> loginMahasiswa(
            @Body MahasiswaObject mahasiswaObject
    );

    @GET("ujianandroid/baca.php")
    Call<MahasiswaContainer> getMahasiswa();

}
