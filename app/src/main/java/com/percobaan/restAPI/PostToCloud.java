package com.percobaan.restAPI;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface PostToCloud {
    @POST("transaksi/insert.php")
    Call<responseUpload> uploadDataTransaksi(
            @Body TransaksiContainer transaksiContainer
    );
}
