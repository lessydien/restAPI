package com.percobaan.restAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retroofitInstance {
    private static Retrofit retrofit;
    //private static final String BASE_URL = "http://192.168.43.249/dienpunya/";

    private static final String BASE_URL = "http://192.168.9.13/dienpunya/";

    public static Retrofit getRetrofitInstance() {
       // HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      //  interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
       // OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }



}
