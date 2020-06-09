package com.percobaan.restAPI;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private MahasiswaObject mahasiswaObject;
    private MahasiswaContainer mahasiswaContainer;
    private EditText etNama, etPass;
    private String strNama, strPass;
    private InternetService internetService ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama =findViewById(R.id.nama);
        etPass =findViewById(R.id.pass);
        internetService =  new InternetService();

    }

    public void login(View view) {
       // if (internetService.isOnline()) {
            strNama  = etNama.getText().toString();
            strPass  = etPass.getText().toString();
            //Toast.makeText(getApplicationContext(),strPass, Toast.LENGTH_SHORT).show();
            mahasiswaObject = new MahasiswaObject(1,strNama,strPass,"");
            Call<responseLogin> loginCall = new RestRepo().loginMahasiswa(mahasiswaObject);
            loginCall.enqueue(new Callback<responseLogin>() {
                @Override
                public void onResponse(Call<responseLogin> call, Response<responseLogin> response) {
                    try{
                        Log.e("response-success", response.body().toString());
                        panggilHalaman(response);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    //Toast.makeText(getApplicationContext(),"Berhasil Login", Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onFailure(Call<responseLogin> call, Throwable t) {
                   Toast.makeText(getApplicationContext(),"Gagal Login", Toast.LENGTH_SHORT).show();
                    t.printStackTrace();
                   //Log.e("response-failure", "" + call);
                }
            });


      //  }
      //  else{
      //     Toast.makeText(getApplicationContext(),"Tidak ada koneksi", Toast.LENGTH_SHORT).show();
      //  }
    }

    public void panggilHalaman(Response<responseLogin> responselogin){
        Intent intent;
        intent = new Intent(this, Biodata.class);
        startActivity(intent);
    }

}
