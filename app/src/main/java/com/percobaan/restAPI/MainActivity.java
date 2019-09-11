package com.percobaan.restAPI;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private TransaksiObject transaksiObject;
    private TransaksiContainer transaksiContainer;
    private List<TransaksiObject> myList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transaksiObject = new TransaksiObject(4,"BBB","2019-06-10 04:03:53" ,
                "2019-06-10 04:03:53", 1,1,2000);

    }

    public void uploadData(View view) {

        ConnectivityManager conMgr =  (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo != null){
            NetworkInfo networkInfo  = conMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            boolean isWifiConn = networkInfo.isConnected();
            networkInfo = conMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            boolean isMobileConn = networkInfo.isConnected();
            if(isMobileConn || isWifiConn){
                myList.add(transaksiObject);
                transaksiContainer = new TransaksiContainer();
                transaksiContainer.setTransaksiObject(myList);
                PostToCloud status_upload= retroofitInstance.getRetrofitInstance().create(PostToCloud.class);
                Call<responseUpload> callUpload = status_upload.uploadDataTransaksi(transaksiContainer);

                callUpload.enqueue(new Callback<responseUpload>() {
                    @Override
                    public void onResponse(Call<responseUpload> call, Response<responseUpload> response) {
                        try{
                            Log.e("response-success", response.body().toString());
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<responseUpload> call, Throwable t) {
                        Log.e("response-failure", call.toString());
                    }
                });

            }
            else {
                new AlertDialog.Builder(this)
                        .setTitle(getResources().getString(R.string.app_name))
                        .setMessage("No Internet")
                        .setPositiveButton("OK", null).show();
            }

        }
        else{
            new AlertDialog.Builder(this)
                    .setTitle(getResources().getString(R.string.app_name))
                    .setMessage("No Internet")
                    .setPositiveButton("OK", null).show();
        }

    }
}
