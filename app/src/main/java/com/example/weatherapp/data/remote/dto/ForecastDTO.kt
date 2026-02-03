package com.example.weatherapp.data.remote.dto

data class ForecastDTO(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)