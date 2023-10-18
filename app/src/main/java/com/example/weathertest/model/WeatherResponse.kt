package com.example.weathertest.model

data class WeatherResponse (
    val code: String,
    val updateTime: String,
    val now: WeatherDetails
)

data class WeatherDetails(
    val temp: String,
    val feelsLike: String,
)