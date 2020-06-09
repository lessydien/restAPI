package com.percobaan.restAPI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Biodata extends AppCompatActivity {
    private MahasiswaContainer mahasiswaContainer;
  //  private List<MahasiswaObject> mahasiswaObjectsList=  new ArrayList<>();;
    private MahasiswaObject mahasiswaObject;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);
        textView =findViewById(R.id.textView);
        getMahasiswa();

    }


    public void getMahasiswa() {
        Call<MahasiswaContainer> getMahasiswaCLoud = new RestRepo().getMahasiswa();
        getMahasiswaCLoud.enqueue(new Callback<MahasiswaContainer>() {
            @Override
            public void onResponse(Call<MahasiswaContainer> call, Response<MahasiswaContainer> response) {
                try {
                    Log.e("response-success", response.body().toString());
                    tampilMahasiswa(response.body().getMahasiswaObject());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //Toast.makeText(getApplicationContext(),"Berhasil Login", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<MahasiswaContainer> call, Throwable t) {

            }


        });

    }

    public void tampilMahasiswa(List<MahasiswaObject> mahasiswaObjectsList){
        String mahasiswa = "";
        String nama = "";
        int size = mahasiswaObjectsList.size();
        if (size !=0) {
            for (int i = 0; i < size; i++) {
                // ambil nama mahasiswa
                nama = nama + mahasiswaObjectsList.get(i).getNama();

                // convert object to string
                mahasiswa = mahasiswa + mahasiswaObjectsList.get(i).toString();
            }
        }

        textView.setText(mahasiswa);

    }

}
