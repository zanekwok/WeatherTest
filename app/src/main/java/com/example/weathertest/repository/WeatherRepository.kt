package com.example.weathertest.repository;

import com.example.weathertest.api.RetrofitService
import com.example.weathertest.api.WeatherApi
import com.example.weathertest.model.WeatherDetails


class WeatherRepository(private val api: WeatherApi = RetrofitService.weatherApi) {
    suspend fun getWeather(location: String, key: String): WeatherDetails {
        return api.getWeather(location, key).now
    }
}
