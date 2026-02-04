package com.example.weatherapp.data.remote.api

import com.example.weatherapp.data.remote.dto.ForecastDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface weatherAPI {
    @GET("forecast.json")
    suspend fun getWeatherForecast(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("days") days: Int,
        @Query("alerts") alerts: String
    ): ForecastDTO
}