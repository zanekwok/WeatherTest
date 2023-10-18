package com.example.weathertest.api

import com.example.weathertest.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("v7/weather/now")
    suspend fun getWeather(@Query("location") location: String, @Query("key") key: String): WeatherResponse
}