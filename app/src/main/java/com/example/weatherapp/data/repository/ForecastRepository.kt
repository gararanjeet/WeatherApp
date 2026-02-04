package com.example.weatherapp.data.repository

import android.util.Log
import com.example.weatherapp.data.remote.api.weatherAPI

class ForecastRepository(
    private val apiService: weatherAPI
) {
    suspend fun getForecastWeather() {
        val result = apiService.getWeatherForecast("1be2a214f48a42e5815150328260302", "visakhapatnam", 3, "no")
        Log.d("result", result.toString())
    }
}