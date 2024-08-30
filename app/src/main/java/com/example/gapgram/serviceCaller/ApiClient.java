package com.example.gapgram.serviceCaller;


import android.util.Log;  // افزودن ایمپورت برای لاگ

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "http://10.0.2.2:8000/api/";
    private static Retrofit retrofit = null;
    private static final String TAG = "ApiClient";  // تعریف یک تگ برای لاگ‌ها

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            Log.d(TAG, "Creating new Retrofit instance");  // لاگ در زمان ایجاد Retrofit


            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS) // افزایش زمان اتصال به 60 ثانیه
                    .readTimeout(60, TimeUnit.SECONDS)    // افزایش زمان خواندن به 60 ثانیه
                    .writeTimeout(60, TimeUnit.SECONDS);  // افزایش زمان نوشتن به 60 ثانیه
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(clientBuilder.build())
                    .build();

            Log.d(TAG, "Retrofit instance created");  // لاگ بعد از ایجاد Retrofit
        } else {
            Log.d(TAG, "Using existing Retrofit instance");  // لاگ در صورتی که از instance موجود استفاده می‌شود
        }
        return retrofit;
    }
}