package com.example.weatherapp.data.remote

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.remote.api.weatherAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.jvm.java

object RetrofitProvider {

    private lateinit var retrofit: Retrofit
    private lateinit var retrofitService: weatherAPI

    private fun createRetrofit() {
        val client = OkHttpClient()
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val clientBuilder = client.newBuilder().addInterceptor(interceptor)

        retrofit = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientBuilder.build())
            .build()
    }


    fun init() {
        createRetrofit()
        retrofitService = retrofit.create(weatherAPI::class.java)

    }

    fun getRetrofitService(): weatherAPI {
        return retrofitService
    }
}