package com.example.androidpreparation.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val baseUrl = "https://api.openweathermap.org/data/2.5/"
    // API Key : 7253c05e938f06aca10a8a26b2027685

    var interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
    val okHttpClient = OkHttpClient.Builder().addInterceptor( interceptor).build()
    fun getInstance() : Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}
