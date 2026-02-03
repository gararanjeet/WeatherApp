package com.example.weatherapp.data.remote.api

interface weatherAPI {
    suspend fun getWeatherForecast()
}