package com.carebanks.retrofit;

import com.carebanks.constants.Constants;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppClient {
    private static final String BASE_URL = Constants.isDebug ?  "https://carebanks.co.uk/care1/" : "https://carebanks.co.uk/care1/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(3000, TimeUnit.SECONDS)
                .writeTimeout(3000, TimeUnit.SECONDS)
                .connectTimeout(5000, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                                    .registerTypeAdapter(Date.class, new CustomSerializer())
                                    .create()))
                    .build();
        }

        return retrofit;
    }
}
